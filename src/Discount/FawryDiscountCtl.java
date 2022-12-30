package Discount;

import java.util.Objects;

public class FawryDiscountCtl {
    public long[] CheckDiscount(){

        long[] arr={0,0,0,0};
        if (Objects.equals(SpecificDiscount.getServicesNameDiscount(), "mobile recharge")){
            arr[0]=SpecificDiscount.getDiscount();
        }else if (Objects.equals(SpecificDiscount.getServicesNameDiscount(), "internet payment")){
            arr[1]=SpecificDiscount.getDiscount();

        }else if (Objects.equals(SpecificDiscount.getServicesNameDiscount(), "landline")){
            arr[2]=SpecificDiscount.getDiscount();

        }else if (Objects.equals(SpecificDiscount.getServicesNameDiscount(), "donations")){
            arr[3]=SpecificDiscount.getDiscount();

        }
        return arr;
    }



}
