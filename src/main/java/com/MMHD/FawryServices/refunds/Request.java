package com.MMHD.FawryServices.refunds;

import com.MMHD.FawryServices.user.User;

public class Request {
    private final String serviceNme;
    private final int servicesId;
    private final long serviceAmount;
    private final String userName;
    private final int userId;
    private String State="waiting";//( waiting , accepted , rejected) , every refund in start -> waiting
    public Request(String serviceNme,long serviceAmount,String userName,int id,int userId){
        this.serviceNme = serviceNme;
        this.serviceAmount=serviceAmount;
        this.userName = userName;
        this.userId=userId;
        this.servicesId=id;

    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public int getServicesId(){
        return servicesId;
    }

    public long getServiceAmount() {
        return serviceAmount;
    }

    public String getServiceNme() {
        return serviceNme;
    }

    public String getState() {
        return State;
    }
    public void setState_Accepted() {this.State="accepted";}
    public void setState_Rejected() {this.State="rejected";}



}

