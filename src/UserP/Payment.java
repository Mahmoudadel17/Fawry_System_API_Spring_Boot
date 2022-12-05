package UserP;

import Services.Services;

public interface Payment {
    boolean pay(User user, Services service);
}
