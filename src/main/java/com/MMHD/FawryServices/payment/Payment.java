package com.MMHD.FawryServices.payment;


import com.MMHD.FawryServices.Services.Service;
import com.MMHD.FawryServices.user.User;

public interface Payment {
    boolean pay(User user, Service service);
}
