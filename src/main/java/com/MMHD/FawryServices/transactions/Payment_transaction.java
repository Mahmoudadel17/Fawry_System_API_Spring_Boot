package com.MMHD.FawryServices.transactions;

public class Payment_transaction extends transaction{
    private final String userName;
    private final int userId;
    private final String serviceName;
    private final long serviceAmount;
    public Payment_transaction(String userName,int userId, String serviceName,long serviceAmount){
        this.userName=userName;
        this.userId=userId;
        this.serviceName=serviceName;
        this.serviceAmount=serviceAmount;
    }
    public String getUserName(){return userName;}
    public int getUserId() {
        return userId;
    }
    public String getServiceName() {
        return serviceName;
    }

    public long getServiceAmount() {
        return serviceAmount;
    }
}
