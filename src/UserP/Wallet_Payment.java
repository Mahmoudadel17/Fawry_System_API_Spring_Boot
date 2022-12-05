package UserP;

import Services.Services;

public class Wallet_Payment implements Payment {
    @Override
    public void pay(User user, Services service) {

        System.out.println("Wallet Payment");
        user.getWallet().use_wallet_money(service.getAmount());
    }
}
