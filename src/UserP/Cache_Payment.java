package UserP;

import Services.Services;

public class Cache_Payment implements Payment{
    @Override
    public boolean pay(User user, Services service) {
        System.out.println("Cache_Payment");
        return true;
    }
}
