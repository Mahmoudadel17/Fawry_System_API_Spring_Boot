package com.MMHD.FawryServices.payment;


import com.MMHD.FawryServices.Services.Service;
import com.MMHD.FawryServices.user.User;

public class Wallet_Payment implements Payment {
    @Override
    public boolean pay(User user, Service service) {


        if (service.getAmount() <= user.getWallet().getMoney_balance_Wallet()) {
            user.getWallet().use_wallet_money(service.getAmount());
            System.out.println("Wallet Payment Done " + service.getAmount());
            return true;
        } else {
            System.out.println("Your wallet balance is not enough");
            return false;
        }


    }
}
