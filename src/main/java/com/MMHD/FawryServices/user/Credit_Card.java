package com.MMHD.FawryServices.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Credit_Card {

    private String cardholder_name;
    private String card_number;
    private String expiration_date;
    private String cvv;
    private long money_balance=1000;// assume that user has 1000 Pound
    public Credit_Card(String s1,String s2,String s3,String s4){
        this.cardholder_name=s1;
        this.card_number=s2;
        this.expiration_date=s3;
        this.cvv=s4;
    }
    public long getbalance() {return this.money_balance;}
    public void use_credit_money(long amount) {
        this.money_balance-=amount;
    }

    public String getCardholder_name(){return cardholder_name;}
    public String getCard_number(){return card_number;}
    public String getExpiration_date(){return expiration_date;}
    public String getCVV(){return cvv;}


}
