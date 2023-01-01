package com.MMHD.FawryServices.transactions;


import com.MMHD.FawryServices.user.User;

public class Add_to_wallet_transaction extends transaction{
    private final String userName;
    private final int userId;
    private final long Amount;
    public Add_to_wallet_transaction(String userName,int userId, long amount){
        this.userName=userName;
        this.userId=userId;
        this.Amount=amount;

    }
    public String getUserName(){return userName;}
    public int getUserId() {
        return userId;
    }

    public long getAmount() {
        return Amount;
    }
}
