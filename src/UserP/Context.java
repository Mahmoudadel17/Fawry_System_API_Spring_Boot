package UserP;

import Services.Services;

public class Context {
    protected final Payment Current;
    public Context(Payment newStratgey) {Current = newStratgey;}

    public void pay(User user , Services service){
        Current.pay(user,service);
    }

}
