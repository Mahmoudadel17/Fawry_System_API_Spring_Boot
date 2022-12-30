package Discount;

import Services.Service;
import user.User;


public class OverallDiscounts extends Discountes{
    private static long discount;
    public OverallDiscounts(Service service) {
        super(service);
    }
    public boolean CheckDiscount(User user) {
        return user.getAllServicesPay().size() == 0;
    }

    public static void setDiscount(int discoun){discount=discoun;}
    public static long getDiscount(){return discount;}
    public void setAmount(long amount){super.setAmount(calcDiscout(amount));}
    protected long calcDiscout(long amount){
        return (long) (amount - ((discount/100.0)*amount));
    }



}
