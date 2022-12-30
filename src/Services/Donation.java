package Services;

public class Donation extends Service {
    public Donation(){super("Donation");}

    @Override
    public boolean checkDelivary() {
        return true;
    }
}
