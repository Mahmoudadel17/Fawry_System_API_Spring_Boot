package com.MMHD.FawryServices.user;


import com.MMHD.FawryServices.Services.Service;
import com.MMHD.FawryServices.refunds.Request;

import java.util.LinkedList;

public class User {
    private int id;
    private String name;
    private String mobileNumber;
    private String email;
    private String password;
    private Wallet wallet ;
    private Credit_Card creditCard;
   private final LinkedList<Service> AllServicesPay = new LinkedList<>();
    private final LinkedList<Request> AllRefundRequsets = new LinkedList<>();


    public User(){}
    public User(int id,String userName ,String email,String password)
    {
        this.id=id;
        this.name=userName;
        this.email=email;
        this.password=password;
        wallet = new Wallet();
    }
    public String getMobileNumber(){return this.mobileNumber;}
    public void setMobileNumber(String MOBILE){this.mobileNumber=MOBILE;}
    public String getName(){return this.name;}
    public String getPassword(){return this.password;}
    public String getEmail(){return this.email;}

    public int getId(){return id;}
    public void AddRequest(Request request){
        AllRefundRequsets.add(request);
    }
    public LinkedList<Service> getAllServicesPay(){return AllServicesPay;}
    public LinkedList<Request> getAllRefundRequsets(){
        return AllRefundRequsets;
    }
    public void setCreditCard(Credit_Card creditCard) {
        this.creditCard=creditCard;
    }
    public Credit_Card getCreditCard() {
        return this.creditCard;
    }
    public Wallet getWallet() {
        return this.wallet;
    }
    public void AddService(Service service){
        AllServicesPay.add(service);
    }
    public void RemoveService(int index){
        AllServicesPay.remove(index);
    }


}
