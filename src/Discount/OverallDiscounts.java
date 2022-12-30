package Discount;

import Services.Service;
import user.User;

import java.util.Objects;

public class OverallDiscounts extends Discountes{
    private static long discount;
    private static String ServicesNameDiscount="-1";
    public OverallDiscounts(Service service) {
        super(service);
    }
    public boolean CheckDiscount(User user) {
        return user.getAllServicesPay().size() == 0;
    }

    public void setServicesNameDiscount(String SND){ServicesNameDiscount=SND;}
    public String getServicesNameDiscount(){return ServicesNameDiscount;}

    public void setDiscount(int discoun){discount=discoun;}
    public long getDiscount(){return discount;}

    protected long calcDiscout(long amount){
        return (long) (amount - ((discount/100.0)*amount));
    }



}
