package Discount;

import Services.Services;
import UserP.User;

public class OverallDiscounts extends Discountes{
    private static long discount;
    public OverallDiscounts(Services service) {
        super(service);
    }

    public static boolean CheckDiscount(User user) {
        return user.getAllServicesPay().size() == 0;
    }
    
    public static  void setDiscount(int discoun){discount=discoun;}
    public static  long getDiscount(){return discount;}

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
