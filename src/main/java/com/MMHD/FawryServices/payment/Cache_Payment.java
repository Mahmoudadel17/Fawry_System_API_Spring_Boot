package com.MMHD.FawryServices.payment;

import com.MMHD.FawryServices.Services.Service;
import com.MMHD.FawryServices.user.User;

public class Cache_Payment implements Payment{
    @Override
    public boolean pay(User user, Service service) {
        System.out.println("Cache_Payment");
        return true;
    }
}

