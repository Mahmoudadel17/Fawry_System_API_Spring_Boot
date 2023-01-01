package com.MMHD.FawryServices.ServiceProviders;

public class DataForm {
    private int wayPay=-1;
    private long amount;
    private String phoneNumber;
    private String donationName;

    public long getAmount(){return amount;}
    public String getPhoneNumber() {return phoneNumber;}
    public int getWayPay() {return wayPay;}

    public void setWayPay(int wayPay) {
        this.wayPay = wayPay;
    }

    public String getDonationName() {return donationName;}
}
