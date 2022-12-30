package payment;

import Services.Service;
import user.User;

public class Context {
    protected final Payment Current;
    public Context(Payment newStratgey) {Current = newStratgey;}

    public boolean pay(User user , Service service){
        return Current.pay(user,service);
    }

}