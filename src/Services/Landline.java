package Services;

public class Landline extends Service{
    public Landline(){super("Landline");}

    @Override
    public boolean checkDelivary() {
        return false;
    }
}
