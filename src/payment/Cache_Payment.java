package payment;
import Services.Service;
import user.User;

public class Cache_Payment implements Payment{
    @Override
    public boolean pay(User user, Service service) {
        System.out.println("Cache_Payment");
        return true;
    }
}

