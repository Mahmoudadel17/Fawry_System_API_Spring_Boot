package com.MMHD.FawryServices.CreatorServices;


import com.MMHD.FawryServices.Services.Donation;
import com.MMHD.FawryServices.Services.Service;

public class Donation_Dialog extends DialogService{

    @Override
    public Service CreateService() {
        return new Donation();
    }
}
