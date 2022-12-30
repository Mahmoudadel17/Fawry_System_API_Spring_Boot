import java.util.LinkedList;
import java.util.Scanner;

import Services.Service;
import refunds.Request;
import user.*;
import Discount.*;
import payment.*;
import refunds.*;
import Search.*;
import CreatorServices.*;

public class Main {
    public static FawryLoginCtl FUCTL = new FawryLoginCtl();
    public static FawryPaymentCtl FPYCTL = new FawryPaymentCtl();
    public static FawryDiscountCtl FDICTL = new FawryDiscountCtl();
    public static FawrySearchCtl FSECTL = new FawrySearchCtl();
    public static FawryRefundsCtl FRECTL = new FawryRefundsCtl();

    public static void FirstHomeScreen(){
        System.out.println("\n ________________ First Home Screen  _________________");
        System.out.println("                                                ");
        System.out.println(" _______________________________________________");
        System.out.println("|                                               |");
        System.out.println("|           1- User.                            |");
        System.out.println("|           2- Admin.                           |");
        System.out.println("|           3- Exit.                            |");
        System.out.println(" _______________________________________________");
    }

    public static void LoginUserHomeScreen(){
        System.out.println("\n ________________ User Home Screen  _________________");
        System.out.println("                                                ");
        System.out.println(" welcome to, Fawry System Services              ");
        System.out.println(" _______________________________________________");
        System.out.println("|                                               |");
        System.out.println("|           1- Login.                           |");
        System.out.println("|           2- Sign Up.                         |");
        System.out.println("|           3- Exit.                            |");
        System.out.println(" _______________________________________________");
    }
    public static void UserHomeScreen(){
        System.out.println("\n ________________ User Home Screen  _________________");
        System.out.println("                                                ");
        System.out.println(" welcome to, Fawry System Services              ");
        System.out.println(" _______________________________________________");
        System.out.println("|                                               |");
        System.out.println("|           1- Search for Service.              |");
        System.out.println("|           2- Pay.                             |");
        System.out.println("|           3- Ask for a Refund.                |");
        System.out.println("|           4- show refund requests.            |");
        System.out.println("|           5- Add Funds to Wallet.             |");
        System.out.println("|           6- check any discount.              |");
        System.out.println("|           7- Exit.                            |");
        System.out.println("|_______________________________________________|\n");
    }
    public static void AdminHomeScreen(){
        System.out.println("\n ________________ Admin Home Screen  _________________");
        System.out.println("                                                ");
        System.out.println(" _______________________________________________");
        System.out.println("|                                               |");
        System.out.println("|           1- Add discounts.                   |");
        System.out.println("|           2- list all refund requests.        |");
        System.out.println("|           3- Exit.                            |");
        System.out.println("|_______________________________________________|\n");
    }
    public static void ServicesScreen(){
        System.out.println("\n ________________ Services Screen  _________________");
        System.out.println("                                                ");
        System.out.println(" _______________________________________________");
        System.out.println("|                                               |");
        System.out.println("|           1- Mobile recharge services.        |");
        System.out.println("|           2- Internet Payment services.       |");
        System.out.println("|           3- Landline services.               |");
        System.out.println("|           4- Donations.                       |");
        System.out.println("|_______________________________________________|\n");
    }
    public static void MobileServicesScreen(){
        System.out.println("\n ________________ Mobile Services Screen  _________________");
        System.out.println("                                                ");
        System.out.println(" _______________________________________________");
        System.out.println("|                                               |");
        System.out.println("|           1- Vodafone.                        |");
        System.out.println("|           2- Etisalat.                        |");
        System.out.println("|           3- Orange.                          |");
        System.out.println("|           4- We.                              |");
        System.out.println("|_______________________________________________|\n");
    }
    public static void InternetServicesScreen(){
        System.out.println("\n ________________ Internet Services Screen  _________________");
        System.out.println("                                                ");
        System.out.println(" _______________________________________________");
        System.out.println("|                                               |");
        System.out.println("|           1- Vodafone.                        |");
        System.out.println("|           2- Etisalat.                        |");
        System.out.println("|           3- Orange.                          |");
        System.out.println("|           4- We.                              |");
        System.out.println("|_______________________________________________|\n");
    }
    public static void LandlineServicesScreen(){
        System.out.println("\n ________________ Landline Services Screen  _________________");
        System.out.println("                                                ");
        System.out.println(" _______________________________________________");
        System.out.println("|                                               |");
        System.out.println("|           1- Monthly receipt.                 |");
        System.out.println("|           2- Quarter receipt.                 |");
        System.out.println("|_______________________________________________|\n");
    }
    public static void DonationsServicesScreen(){
        System.out.println("\n ________________ Donations Services Screen  _________________");
        System.out.println("                                                ");
        System.out.println(" __________________________________________________");
        System.out.println("|                                                  |");
        System.out.println("|           1- Cancer Hospital.                    |");
        System.out.println("|           2- Schools.                            |");
        System.out.println("|           3- NGOs (Non profitable organizations).|");
        System.out.println("|__________________________________________________|\n");
    }

    public static void DiscountServicesScreen(long[] arr){

        System.out.println("\n ________________  Discount Services Screen  _________________");
        System.out.println("|                                                              |");
        System.out.println("|           1- Mobile recharge services with "+arr[0]+"% Discount");
        System.out.println("|           2- Internet Payment services with "+arr[1]+"% Discount");
        System.out.println("|           3- Landline services with "+arr[2]+"% Discount");
        System.out.println("|           4- Donations with "+arr[3]+"% Discount");
        System.out.println("|_______________________________________________________________|\n");
    }
    public static void PaymentScreen(){
        System.out.println("\n ________________ Payment Screen  _________________");
        System.out.println("                                                ");
        System.out.println(" _______________________________________________");
        System.out.println("|                                               |");
        System.out.println("|           1- Default Payment.                 |");
        System.out.println("|           2- Wallet Payment.                  |");
        System.out.println("|_______________________________________________|\n");
    }
    public static void DeliveryPaymentScreen(){
        System.out.println("\n ________________ Payment Screen  _________________");
        System.out.println("                                                ");
        System.out.println(" _______________________________________________");
        System.out.println("|                                               |");
        System.out.println("|           1- Default Payment.                 |");
        System.out.println("|           2- Wallet Payment.                  |");
        System.out.println("|           3- Cache Payment.                  |");
        System.out.println("|_______________________________________________|\n");
    }
    public static void displayServicesScreen(LinkedList<Service> matchServices){
        System.out.println("\n ________________ display Services Screen  _________________");
        System.out.println("                                                ");
        System.out.println(" _______________________________________________");
        for (int i=0;i<matchServices.size();i++){
            System.out.println("|    "+(i+1)+"- "+matchServices.get(i).getName());
        }
        System.out.println(" _______________________________________________");
    }

    public static void displayRequestsScreen(LinkedList<Request> AllRefundRequsets){
        if (AllRefundRequsets.size()==0){
            System.out.println("No Refund Requests founded");
        }else {
            System.out.println("\n ________________ display Requests Screen  _________________");
            System.out.println("                                                ");
            for (int i = 0;i<AllRefundRequsets.size();i++){
                System.out.println(" _______________________________________________");
                System.out.println("|      Request ID:   "+(i+1));
                System.out.println("|      Service Name: "+AllRefundRequsets.get(i).getService().getName());
                System.out.println("|      Amount:       "+AllRefundRequsets.get(i).getService().getAmount());
                System.out.println("|      State:        "+AllRefundRequsets.get(i).getState());
                System.out.println("|_______________________________________________|\n");
                System.out.println(" ");
            }
        }


    }

    public static int cinput(int i,int j){
        int SER_Num;
        Scanner homeScan = new Scanner(System.in);
        while (true) {
            try {

                System.out.print("choice: ");
                String s = homeScan.nextLine();
                SER_Num = Integer.parseInt(s);
                if ( SER_Num<i ||  SER_Num>j) {
                    System.out.println("invalid input \n");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("invalid input " + e.getMessage() + "\n");
            }

        }
        return SER_Num;
    }


    public static void main(String[] arg) {

        Scanner homeScan = new Scanner(System.in);
        boolean c=true;

        while(c) {
            //
            int Select_user_or_admin;
            FirstHomeScreen();
            Select_user_or_admin = cinput(1,3);
            if(Select_user_or_admin==1) {
                boolean c1=true;User user=null;

                while(c1) {
                    while (user==null){
                        LoginUserHomeScreen();
                        int ChoiceLOG = cinput(1,3);
                        if( ChoiceLOG==1) {
                            user = FUCTL.Login_user();
                        }else if( ChoiceLOG==2) {
                            user = FUCTL.Sign_Up();
                        }
                        else {
                            System.out.println("Thanks-_-");
                            c1=false;
                        }
                    }
                    UserHomeScreen();
                    int Choice = cinput(1,7);

                    if( Choice==1) {
                        // Search
                        LinkedList<Service> matchServices;
                        System.out.print("Enter your Name of Service: ");
                        String NameService = homeScan.nextLine();
                        matchServices = FSECTL.Search_About_Service(NameService);
                        displayServicesScreen(matchServices);

                    }
                    else if( Choice==2) {
                        // service provider ya naaaaaaasss alhaonyyyyyy
                        // pay
                        ServicesScreen();
                        // select Service
                        int SER_Num = cinput(1,4);
                        Create_Service createService = new Create_Service();
                        DialogService dialogService = createService.CreateService(SER_Num);
                        Service service = dialogService.CreateService();
                        // Payment way
                        int WayPay;
                        if (service.checkDelivary()){
                            DeliveryPaymentScreen();
                            WayPay = cinput(1,3);
                        }else {
                            PaymentScreen();
                            WayPay = cinput(1,2);
                        }
                        Context Payment_Way = new Context(null);

                        if (WayPay== 1)
                            Payment_Way = new Context(new Credit_Card_Payment());
                        else if(WayPay==2)
                            Payment_Way = new Context(new Wallet_Payment());
                        else if (WayPay==3)
                            Payment_Way = new Context(new Cache_Payment());
                        FPYCTL.Pay(user,Payment_Way,service,WayPay);


                    }
                    else if( Choice==3) {
                        // ask refund
                        FRECTL.MakeRefund(user);
                    }
                    else if(Choice==4){
                        // list request
                        displayRequestsScreen(FRECTL.getAllRefundRequsets(user));
                    }
                    else if( Choice==5) {
                        FPYCTL.Add_Funds_to_Wallet(user);
                    }
                    else if( Choice==6) {
                        // discount
                        DiscountServicesScreen(FDICTL.CheckDiscount(user));
                    }else if( Choice==7) {
                        user=null;
                        System.out.println("Thanks-_-");
                        c1=false;
                    }



                }




            }
            else if(Select_user_or_admin == 2 ) {

                boolean c2=true;
                while(c2) {
                    AdminHomeScreen();
                    int Choice1;
                    while (true) {
                        try {

                            System.out.print("choice: ");
                            String s = homeScan.nextLine();
                            Choice1 = Integer.parseInt(s);
                            if ( Choice1<1 ||  Choice1>4) {
                                System.out.println("invalid input \n");
                                continue;
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("invalid input " + e.getMessage() + "\n");
                        }

                    }
                    if( Choice1==1) {
                        // add discount
                        FDICTL.AddDiscount();
                    }else if( Choice1==2) {
                        // list refunds
                        FRECTL.listrefund();
                    }
                    else if( Choice1==3) {
                        System.out.println("Thanks-_-");
                        c2=false;
                    }

                }

            }
            else {
                System.out.println("Good by -_-");
                c=false;
            }
        }












    }


}