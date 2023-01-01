package com.MMHD.FawryServices.CreatorServices;


import com.MMHD.FawryServices.Services.Internet_Payment;
import com.MMHD.FawryServices.Services.Service;

public class Internet_Payment_Dialog extends DialogService{
    @Override
    public Service CreateService() {
        return new Internet_Payment();
    }
}
