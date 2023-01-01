package com.MMHD.FawryServices.transactions;

import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class All_Transactions {
    private static final LinkedList<Add_to_wallet_transaction> All_add_to_wallet_transactions = new LinkedList<>();
    private static final LinkedList<Refund_transaction> All_refund_transactions = new LinkedList<>();
    private static final LinkedList<Payment_transaction> All_payment_transactions = new LinkedList<>();

    public void Add_refund_transactions(Refund_transaction refundTransaction){All_refund_transactions.add(refundTransaction);}
    public void Add_payment_transactions(Payment_transaction paymentTransaction){All_payment_transactions.add(paymentTransaction);}
    public void Add_addToWallet_transactions(Add_to_wallet_transaction addToWalletTransaction){All_add_to_wallet_transactions.add(addToWalletTransaction);}

   public LinkedList<Add_to_wallet_transaction> getAll_add_to_wallet_transactions(){return All_add_to_wallet_transactions;}
    public  LinkedList<Refund_transaction> getAll_refund_transactions(){return All_refund_transactions;}
    public  LinkedList<Payment_transaction> getAll_payment_transactions(){return All_payment_transactions;}


}
