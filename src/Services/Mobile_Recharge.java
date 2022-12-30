package Services;

public class Mobile_Recharge extends Service{
    public Mobile_Recharge(){super("Mobile Recharge");}

    @Override
    public boolean checkDelivary() {
        return false;
    }
}
