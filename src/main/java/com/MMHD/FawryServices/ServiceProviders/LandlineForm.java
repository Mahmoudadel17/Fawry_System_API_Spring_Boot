package com.MMHD.FawryServices.ServiceProviders;

import java.util.Objects;

public class LandlineForm implements Form{
    @Override
    public long getRequiredData(DataForm dataForm) {
        if (Objects.equals(dataForm.getPhoneNumber(),null) ||  dataForm.getWayPay()>2){
            return -1;
        }
        if (dataForm.getWayPay()==-1) {
            dataForm.setWayPay(1);
        }
        if (dataForm.getPhoneNumber().length()==8 ){
            int lastnumber = dataForm.getPhoneNumber().charAt(7)-'0';
            if (lastnumber>=0 && lastnumber<=4){
                return 100;
            }else
            {
                return 250;
            }
        }
        return -1;
    }
}
