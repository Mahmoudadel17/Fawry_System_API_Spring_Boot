package UserP;

import Services.Services;

public class Wallet_Payment implements Payment {
    @Override
    public boolean pay(User user, Services service) {


        if (service.getAmount()<=user.getWallet().wallet_money()){
            user.getWallet().use_wallet_money(service.getAmount());
            System.out.println("Wallet Payment Done "+service.getAmount());
            return true;
        }
        else {
            System.out.println("Your wallet balance is not enough");
            return false;
        }

    }
}
