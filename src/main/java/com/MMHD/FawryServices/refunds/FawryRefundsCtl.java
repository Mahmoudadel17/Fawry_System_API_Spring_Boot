package com.MMHD.FawryServices.refunds;


import com.MMHD.FawryServices.Services.Service;
import com.MMHD.FawryServices.transactions.All_Transactions;
import com.MMHD.FawryServices.transactions.Refund_transaction;
import com.MMHD.FawryServices.user.All_Users;
import com.MMHD.FawryServices.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

import static com.MMHD.FawryServices.user.FawryLoginCtl.currentUserId;

@RestController
public class FawryRefundsCtl {
    All_Refunds allRefunds = new All_Refunds();
    All_Users allUsers = new All_Users();
    @GetMapping(value = "/Refund/GetAllServicesPay")
    public ResponseEntity<LinkedList<String>> GetAllServicesPay(){
        User user = allUsers.Search_About_UserID(currentUserId);
        if (user!=null){
            LinkedList<Service> userServices = user.getAllServicesPay();
            LinkedList<String> servicesName = new LinkedList<>();
            int i=1;
            for (Service service:userServices){
                String name = i+" "+ service.getName();
                servicesName.add(name);
                i++;
            }
            return ResponseEntity.ok( servicesName);
        }
        return ResponseEntity.status(HttpStatus.NETWORK_AUTHENTICATION_REQUIRED).build();

    }

    @PostMapping(value = "/Refund/MakeRefund/{id}")
    public ResponseEntity<String> MakeRefund(@PathVariable("id")int id){
        User user = allUsers.Search_About_UserID(currentUserId);
        if (user != null){
            if(user.getAllServicesPay().size()!=0 && id <= user.getAllServicesPay().size() && id>0) {
                if (!user.getAllServicesPay().get(id - 1).isCheckRef()){
                    Request request = new Request(user.getAllServicesPay().get(id-1).getName(),user.getAllServicesPay().get(id-1).getAmount(),user.getName(),id,user.getId());
                    allRefunds.AddRequest(request);
                    user.AddRequest(request);
                    user.getAllServicesPay().get(id-1).setCheckRef();
                    // transaction
                    Refund_transaction refundTransaction = new Refund_transaction(request);
                    All_Transactions allTransactions = new All_Transactions();
                    allTransactions.Add_refund_transactions(refundTransaction);

                    return ResponseEntity.ok("Refund Added successful");
                }
                else {
                    return ResponseEntity.ok("Sorry, This Service Refunded before ");
                }
            } else if (id > user.getAllServicesPay().size() || id<=0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            } else {

                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }
        return ResponseEntity.status(HttpStatus.NETWORK_AUTHENTICATION_REQUIRED).build();

    }

    @GetMapping(value = "/Refund/UserRefundRequests")
    public ResponseEntity<LinkedList<Request>> getAllUserRefundRequsets(){
    User user = allUsers.Search_About_UserID(currentUserId);
    if (user != null){
        return ResponseEntity.ok(user.getAllRefundRequsets());
    }
    return ResponseEntity.status(HttpStatus.NETWORK_AUTHENTICATION_REQUIRED).build();
    }

    @GetMapping(value = "/Refund/RefundRequests")
    public ResponseEntity<LinkedList<Request>> getAllRefundRequsets(){
        if (allRefunds.getAllRequest().size()!=0){
            return ResponseEntity.ok(allRefunds.getAllRequest());
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PostMapping(value = "/Refund/HandleRefunds/{id}/{stat}")
    public ResponseEntity<String> handlerefunds(@PathVariable("id") int id,@PathVariable("stat") boolean stat){
        if (id<=allRefunds.getAllRequest().size() && id > 0 && allRefunds.getAllRequest().size()!=0)
        {
            if (stat){
                allRefunds.getAllRequest().get(id-1).setState_Accepted();
                Request request = allRefunds.getRemovedRequest(id-1);
                // remove service from user pay service
                User user = allUsers.Search_About_UserID(request.getUserId());
                user.RemoveService(request.getServicesId()-1);
                // add amount to user wallet
                user.getWallet().add_to_wallet(request.getServiceAmount());
                return ResponseEntity.ok("Accepted Refund successful");
            }
            else{
                allRefunds.getAllRequest().get(id-1).setState_Rejected();
                allRefunds.RemoveRequest(id-1);
                return ResponseEntity.ok("Rejected Refund successful");
            }
        }
        else if( allRefunds.getAllRequest().size()==0){
            return ResponseEntity.ok("No Refund now");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }



}

