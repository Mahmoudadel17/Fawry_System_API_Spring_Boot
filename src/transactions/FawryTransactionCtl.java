package transactions;

import user.User;

import java.util.LinkedList;
import java.util.Objects;

public class FawryTransactionCtl {
    All_Transactions allTransactions = new All_Transactions();
    public LinkedList<Add_to_wallet_transaction> Search_about_addToWallet_user_transactions(User user){
        LinkedList<Add_to_wallet_transaction> userTransaction = new LinkedList<>();
        LinkedList<Add_to_wallet_transaction> All_add_to_wallet_transactions  = allTransactions.getAll_add_to_wallet_transactions();
        for (Add_to_wallet_transaction obj:All_add_to_wallet_transactions){
            if (Objects.equals(obj.getUserTransaction().getEmail(), user.getEmail())){
                userTransaction.add(obj);
            }
        }
        return userTransaction;
    }
    public  LinkedList<Refund_transaction> Search_about_refund_user_transactions(User user){
        LinkedList<Refund_transaction>userTransaction = new LinkedList<>();
        LinkedList<Refund_transaction> All_refund_transactions = allTransactions.getAll_refund_transactions();
        for (Refund_transaction obj:All_refund_transactions){
            if (Objects.equals(obj.getUserTransaction().getEmail(), user.getEmail())){
                userTransaction.add(obj);
            }
        }
        return userTransaction;
    }
    public  LinkedList<Payment_transaction> Search_about_payment_user_transactions(User user){
        LinkedList<Payment_transaction> userTransaction = new LinkedList<>();
        LinkedList<Payment_transaction> All_payment_transactions = allTransactions.getAll_payment_transactions();
        for (Payment_transaction obj:All_payment_transactions){
            if (Objects.equals(obj.getUserTransaction().getEmail(), user.getEmail())){
                userTransaction.add(obj);
            }
        }
        return userTransaction;
    }

}
