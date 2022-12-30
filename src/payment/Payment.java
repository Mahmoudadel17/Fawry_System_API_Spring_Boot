package payment;

import Services.Service;
import user.User;

public interface Payment {
    boolean pay(User user, Service service);
}
