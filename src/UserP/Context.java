package UserP;

import Services.Services;

public class Context {
    protected final Payment Current;
    public Context(Payment newStratgey) {Current = newStratgey;}

    public boolean pay(User user , Services service){
        return Current.pay(user,service);
    }

}
