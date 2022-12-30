package Services;

public class Internet_Payment extends Service{
    public Internet_Payment(){super("Internet Payment");}

    @Override
    public boolean checkDelivary() {
        return false;
    }
}
