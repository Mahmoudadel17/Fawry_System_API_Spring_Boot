package Discount;

import Services.Services;
import java.util.Objects;

public class SpecificDiscount extends Discountes{
    private static long discount;
    private static String ServicesNameDiscount="-1";

    public SpecificDiscount(Services service) {
        super(service);
    }


    public static boolean CheckDiscount(Services service) {
        if (Objects.equals(ServicesNameDiscount, "-1"))
        {
            return false;
        }
        String s = service.getName();
        return s.contains(ServicesNameDiscount);

    }

    public static void setServicesNameDiscount(String SND){ServicesNameDiscount=SND;}
    public static String getServicesNameDiscount(){return ServicesNameDiscount;}
    
    public static  void setDiscount(int discoun){discount=discoun;}
    public static long getDiscount(){return discount;}

    protected long calcDiscout(long amount){
        return (long) (amount - ((discount/100.0)*amount));
    }
    @Override
    public void setAmount(long amount) {
        super.setAmount(calcDiscout(amount));

    }

    @Override
    public long getAmount() {
        return super.getAmount();
    }

    @Override
    public boolean checkDelivary() {
        return super.checkDelivary();
    }

    @Override
    public String getName() {
        return super.getName();
    }

}
