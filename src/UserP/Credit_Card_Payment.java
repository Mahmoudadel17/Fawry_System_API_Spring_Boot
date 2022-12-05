package UserP;

import Services.Services;

public class Credit_Card_Payment implements Payment{
    @Override
    public void pay(User user, Services service) {
        System.out.println("Credit card");
        user.getCreditCard().use_credit_money(service.getAmount());
    }
}
