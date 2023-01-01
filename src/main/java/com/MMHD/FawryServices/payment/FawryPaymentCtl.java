package com.MMHD.FawryServices.payment;

import com.MMHD.FawryServices.CreatorServices.Create_Service;
import com.MMHD.FawryServices.CreatorServices.DialogService;
import com.MMHD.FawryServices.Discount.OverallDiscounts;
import com.MMHD.FawryServices.Discount.SpecificDiscount;
import com.MMHD.FawryServices.Search.SearchingList;
import com.MMHD.FawryServices.ServiceProviders.DataForm;
import com.MMHD.FawryServices.ServiceProviders.Form;
import com.MMHD.FawryServices.ServiceProviders.ServiceProvider;
import com.MMHD.FawryServices.Services.Service;
import com.MMHD.FawryServices.transactions.Add_to_wallet_transaction;
import com.MMHD.FawryServices.transactions.All_Transactions;
import com.MMHD.FawryServices.transactions.Payment_transaction;
import com.MMHD.FawryServices.user.All_Users;
import com.MMHD.FawryServices.user.Credit_Card;
import com.MMHD.FawryServices.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.Objects;


import static com.MMHD.FawryServices.user.FawryLoginCtl.currentUserId;

@RestController
public class FawryPaymentCtl {
    All_Users allUsers = new All_Users();
    Form myForm = null;
    Service service = null;
    @PostMapping (value = "/Payment/CCinformation")
    public ResponseEntity<String> SetCredit_Card_Information(@RequestBody Credit_Card creditCard) {
        if (Objects.equals(creditCard.getCardholder_name(),null) ||
                Objects.equals(creditCard.getCard_number(),null) ||
                Objects.equals(creditCard.getExpiration_date(), null) ||
                Objects.equals(creditCard.getCVV(),null)){

            return ResponseEntity.badRequest().body("invalid data");
        }
        Credit_Card card = new Credit_Card(creditCard.getCardholder_name(),creditCard.getCard_number(),creditCard.getExpiration_date(),creditCard.getCVV());
        User user = allUsers.Search_About_UserID(currentUserId);
        if (user!=null){
            user.setCreditCard(card);
            return ResponseEntity.ok("DONE ");
        }
        return ResponseEntity.status(HttpStatus.NETWORK_AUTHENTICATION_REQUIRED).build();

    }

    @PostMapping (value = "/Payment/AddFundsTOWallet/{amount}")
    public ResponseEntity<String> Add_Funds_to_Wallet(@PathVariable("amount") long amount) {
        if (amount<0){
            return ResponseEntity.badRequest().body("invalid data");
        }
        User user = allUsers.Search_About_UserID(currentUserId);
        if(user==null) {
            return ResponseEntity.status(HttpStatus.NETWORK_AUTHENTICATION_REQUIRED).build();
        }
        else {

            Credit_Card card = user.getCreditCard();
            if(card==null) {
                return ResponseEntity.ok("Please Set Your Credit Card Information");
            }else
            {
                if(card.getbalance()>=amount) {
                    card.use_credit_money(amount);
                    user.getWallet().add_to_wallet(amount);
                    // transaction
                    Add_to_wallet_transaction addToWalletTransaction = new Add_to_wallet_transaction(user.getName(),user.getId(),amount);
                    All_Transactions allTransactions = new All_Transactions();
                    allTransactions.Add_addToWallet_transactions(addToWalletTransaction);

                    return ResponseEntity.ok("Your Wallet money now is : "+user.getWallet().getMoney_balance_Wallet());
                }
                else {
                    return ResponseEntity.ok("Sorry this Amount Not available in your account, your balance is : "+card.getbalance());
                }
            }


        }

    }
    @GetMapping(value = "/Payment/getNameServicesList")
    public ResponseEntity<LinkedList<String>> getNameServicesList() {
        SearchingList searchingList = new SearchingList();
        LinkedList<Service> Services = searchingList.getServicesList();
        LinkedList<String> allNameServices = new LinkedList<>();
        allNameServices.add("id :    Service Name");
        int i=1;
        for (Service service : Services) {
            allNameServices.add(i +" :  "+ service.getName());
            i++;
        }
        return ResponseEntity.ok(allNameServices);
    }

    @GetMapping(value = "/Payment/getNamesServiceProvider/{serviceID}")
    public ResponseEntity<LinkedList<String>> getNamesServiceProvider(@PathVariable("serviceID") int id){
        SearchingList searchingList = new SearchingList();
        LinkedList<Service> Services = searchingList.getServicesList();
        if (id<=0 || id >Services.size()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        LinkedList<ServiceProvider> ServicesProvider = Services.get(id-1).getAllServicesProvider();
        LinkedList<String> allNameServiceProvider = new LinkedList<>();
        allNameServiceProvider.add("id :    Service Provider Name");
        int i=1;
        for (ServiceProvider obj:ServicesProvider){
            allNameServiceProvider.add(i+" : "+obj.getServiceProviderName());
            i++;
        }
        return ResponseEntity.ok(allNameServiceProvider);
    }

    @GetMapping(value = "/Payment/WayPayment/{ServiceId}")
    public ResponseEntity<LinkedList<String>> getWayPayment(@PathVariable("ServiceId") int id){
        SearchingList searchingList = new SearchingList();
        LinkedList<Service> Services = searchingList.getServicesList();
        if (id<=0 || id >Services.size()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        LinkedList<String> wayPayment = new LinkedList<>();
        wayPayment.add("number of way : Name of Way Payment");
        wayPayment.add(" 1  :  Credit Card ");
        wayPayment.add(" 2  :  Wallet ");
        Service myService = Services.get(id-1);
        if (myService.checkDelivary()){
            wayPayment.add(" 3  :  Cache ");
        }
        return ResponseEntity.ok(wayPayment);
    }

    @PostMapping(value = "/Payment/PaymentService/{ServiceId}/{ServiceProviderId}")
    public ResponseEntity<String> PaymentService(@PathVariable("ServiceId") int SER_Num,@PathVariable("ServiceProviderId") int SER_PRO_Num){
        if (SER_Num<=0 || SER_Num>4){
            return ResponseEntity.badRequest().body("invalid Data form ");
        }
        // CREATE SERVICE USER SELECT
        Create_Service createService = new Create_Service();
        DialogService dialogService = createService.CreateService(SER_Num);
        service = dialogService.CreateService();
        if (SER_PRO_Num<=0 || SER_PRO_Num> service.getAllServicesProvider().size()){
            return ResponseEntity.badRequest().body("invalid Data form ");
        }
        myForm = service.getAllServicesProvider().get(SER_PRO_Num - 1).get_form();
        return ResponseEntity.ok("Select Payment Service successful");
}
    @PostMapping(value = "/Payment/pay")
    public ResponseEntity<String> pay(@RequestBody DataForm dataForm){
    	if(myForm==null || service==null) {
    		return ResponseEntity.badRequest().body("please select service you want to pay it!! ");
    	}
        User user = allUsers.Search_About_UserID(currentUserId);
        if (user!=null){

            long Amount = myForm.getRequiredData(dataForm);
            if (dataForm.getPhoneNumber()!=null){
                user.setMobileNumber(dataForm.getPhoneNumber());
            }
            if (Amount==-1){
                return ResponseEntity.badRequest().body("invalid Data form ");
            }else {
                Context Payment_Way = new Context(null);
                int WayPay = dataForm.getWayPay();
                if (WayPay == 1)
                    Payment_Way = new Context(new Credit_Card_Payment());
                else if (WayPay == 2)
                    Payment_Way = new Context(new Wallet_Payment());
                else if (WayPay == 3)
                    Payment_Way = new Context(new Cache_Payment());

                SpecificDiscount specificDiscount = new SpecificDiscount(service);
                OverallDiscounts overallDiscounts = new OverallDiscounts(service);

                if (specificDiscount.CheckDiscount(service)) {
                    service = new SpecificDiscount(service);
                }
                if (overallDiscounts.CheckDiscount(user)) {
                    service = new OverallDiscounts(service);
                }
                service.setAmount(Amount);
                Credit_Card card = user.getCreditCard();
                if (card == null && WayPay == 1) {
                    return ResponseEntity.badRequest().body("Please Set Your Credit Card Information");
                }

                boolean payDone = Payment_Way.pay(user, service);
                if (WayPay != 3 && payDone) {
                    user.AddService(service);

                }
                if (payDone) {
                    // transaction
                    Payment_transaction paymentTransaction = new Payment_transaction(user.getName(),user.getId(), service.getName(),service.getAmount());
                    All_Transactions allTransactions = new All_Transactions();
                    allTransactions.Add_payment_transactions(paymentTransaction);
                    myForm=null;
                    service=null;
                    return ResponseEntity.ok("Payment successful");

                }else{
                    return ResponseEntity.badRequest().body("balance is not enough");
                }
            }


        }

        return ResponseEntity.status(HttpStatus.NETWORK_AUTHENTICATION_REQUIRED).build();



    }




}
