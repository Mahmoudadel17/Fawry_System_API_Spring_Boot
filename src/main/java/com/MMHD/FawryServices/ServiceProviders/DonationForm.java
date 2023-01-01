package com.MMHD.FawryServices.ServiceProviders;

import java.util.Objects;

public class DonationForm implements Form{
    @Override
    public long getRequiredData(DataForm dataForm) {
        if (Objects.equals(dataForm.getDonationName(),null) || dataForm.getAmount()<=0 || dataForm.getWayPay()>3){
            return -1;
        }
        if (dataForm.getWayPay()==-1) {
            dataForm.setWayPay(1);
        }
        String s = dataForm.getDonationName().toLowerCase();
        if (Objects.equals(s, "cancer hospital") || Objects.equals(s, "schools") ||Objects.equals(s, "ngo")){
            return dataForm.getAmount();
        }
       return -1;
    }
}
