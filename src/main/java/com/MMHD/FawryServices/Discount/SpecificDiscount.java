package com.MMHD.FawryServices.Discount;

import com.MMHD.FawryServices.Services.Service;

import java.util.Objects;

public class SpecificDiscount extends Discountes{
    private static long discount;
    private static String ServicesNameDiscount="-1";

    public SpecificDiscount(Service service) {
        super(service);
    }
    public boolean CheckDiscount(Service service) {
        if (Objects.equals(ServicesNameDiscount, "-1"))
        {
            return false;
        }
        String s = service.getName().toLowerCase();
        return s.contains(ServicesNameDiscount.toLowerCase());

    }

    public static void setServicesNameDiscount(String SND){ServicesNameDiscount=SND;}
    public static String getServicesNameDiscount(){return ServicesNameDiscount;}

    public static  void setDiscount(int discoun){discount=discoun;}
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
