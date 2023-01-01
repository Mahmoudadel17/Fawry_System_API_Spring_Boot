package com.MMHD.FawryServices.CreatorServices;

import com.MMHD.FawryServices.Services.Mobile_Recharge;
import com.MMHD.FawryServices.Services.Service;

public class Mobile_Recharge_Dialog extends DialogService{
    @Override
    public Service CreateService() {
        return new Mobile_Recharge();
    }
}
