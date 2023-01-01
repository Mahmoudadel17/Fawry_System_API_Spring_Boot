package com.MMHD.FawryServices.transactions;


import com.MMHD.FawryServices.user.All_Users;
import com.MMHD.FawryServices.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.Objects;

@RestController
public class FawryTransactionCtl {
    All_Transactions allTransactions = new All_Transactions();
    All_Users allUsers = new All_Users();

    @GetMapping(value = "/Transaction/ShowAllUsers")
    public ResponseEntity<LinkedList<String>> getAllUsers(){
        if (allUsers.getAlluser().size()==0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        LinkedList<String> users = new LinkedList<>();
        users.add("id :    User Name");
        for (User obj:allUsers.getAlluser()){
            users.add(obj.getId()+" :  "+obj.getName() );
        }
        return ResponseEntity.ok(users);
    }
    @RequestMapping(value = "/Transaction/Search_wallet_transaction/{userId}",method = RequestMethod.GET)
    public ResponseEntity<LinkedList<Add_to_wallet_transaction>> Search_about_addToWallet_user_transactions(@PathVariable("userId") int id){
        if (id<=0 || id>allUsers.getAlluser().size()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        LinkedList<Add_to_wallet_transaction> userTransaction = new LinkedList<>();
        LinkedList<Add_to_wallet_transaction> All_add_to_wallet_transactions  = allTransactions.getAll_add_to_wallet_transactions();
        for (Add_to_wallet_transaction obj:All_add_to_wallet_transactions){
            User user = allUsers.Search_About_UserID(obj.getUserId());
            if (Objects.equals(user.getId(), id)){
                userTransaction.add(obj);
            }
        }
        return ResponseEntity.ok(userTransaction);
    }
    @RequestMapping(value = "/Transaction/Search_refund_transaction/{userId}",method = RequestMethod.GET)
    public  ResponseEntity<LinkedList<Refund_transaction>> Search_about_refund_user_transactions(@PathVariable("userId") int id){
        if (id<=0 || id>allUsers.getAlluser().size()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        LinkedList<Refund_transaction>userTransaction = new LinkedList<>();
        LinkedList<Refund_transaction> All_refund_transactions = allTransactions.getAll_refund_transactions();
        for (Refund_transaction obj:All_refund_transactions){
            User user = allUsers.Search_About_UserID(obj.getRefundRequestTransaction().getUserId());
            if (Objects.equals(user.getId(), id)){
                userTransaction.add(obj);
            }
        }
        return ResponseEntity.ok(userTransaction);
    }
    @RequestMapping(value = "/Transaction/Search_Payment_transaction/{userId}",method = RequestMethod.GET)
    public ResponseEntity<LinkedList<Payment_transaction>>  Search_about_payment_user_transactions(@PathVariable("userId") int id){
        if (id<=0 || id>allUsers.getAlluser().size()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        LinkedList<Payment_transaction> userTransaction = new LinkedList<>();
        LinkedList<Payment_transaction> All_payment_transactions = allTransactions.getAll_payment_transactions();
        for (Payment_transaction obj:All_payment_transactions){
            User user = allUsers.Search_About_UserID(obj.getUserId());
            if (Objects.equals(user.getId(), id)){
                userTransaction.add(obj);
            }
        }

        return ResponseEntity.ok(userTransaction);
    }

}
