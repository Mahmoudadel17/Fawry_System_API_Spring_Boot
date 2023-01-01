package com.MMHD.FawryServices.ServiceProviders;

import java.util.Objects;

public class WeForm implements Form{
    @Override
    public long getRequiredData(DataForm dataForm) {
        if (Objects.equals(dataForm.getPhoneNumber(),null) || dataForm.getAmount()<=0  || dataForm.getWayPay()>2){
            return -1;
        }
        if (dataForm.getWayPay()==-1) {
            dataForm.setWayPay(1);
        }
        String num = dataForm.getPhoneNumber();

        if (num.charAt(0)=='0' && num.charAt(1)=='1' && num.charAt(2)=='5' && num.length()==11){
            return (long) (dataForm.getAmount() + ((3/100.0)*dataForm.getAmount()) );
        }
        return -1;
    }
}
