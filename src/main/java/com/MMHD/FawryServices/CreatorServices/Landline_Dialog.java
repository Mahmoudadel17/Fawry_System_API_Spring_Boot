package com.MMHD.FawryServices.CreatorServices;


import com.MMHD.FawryServices.Services.Landline;
import com.MMHD.FawryServices.Services.Service;

public class Landline_Dialog extends DialogService{
    @Override
    public Service CreateService() {
        return new Landline();
    }
}
