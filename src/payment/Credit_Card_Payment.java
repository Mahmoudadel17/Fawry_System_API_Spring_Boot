package payment;

import Services.Service;
import user.User;

public class Credit_Card_Payment implements Payment{
    @Override
    public boolean pay(User user, Service service) {
        if (service.getAmount()<=user.getCreditCard().getbalance()){
            user.getCreditCard().use_credit_money(service.getAmount());
            System.out.println("Credit card Done "+service.getAmount());
            return true;
        }
        else {
            System.out.println("Your credit card balance is not enough");
            return false;
        }



    }
}