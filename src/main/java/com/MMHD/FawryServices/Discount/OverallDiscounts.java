package com.MMHD.FawryServices.Discount;


import com.MMHD.FawryServices.Services.Service;
import com.MMHD.FawryServices.user.User;

public class OverallDiscounts extends Discountes{
    private static long discount=0;

    public OverallDiscounts(Service service) {
        super(service);
    }
    public boolean CheckDiscount(User user) {
        if (discount==0){
            return false;
        }
        return user.getAllServicesPay().size() == 0;
    }

    public static void setDiscount(int discoun){discount=discoun;}
    public static long getDiscount(){return discount;}

    public void setAmount(long amount){super.setAmount(calcDiscout(amount));}

    @Override
    public long getAmount() {
        return super.getAmount();
    }

    protected long calcDiscout(long amount){
        return (long) (amount - ((discount/100.0)*amount));

    }



}
