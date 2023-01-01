package com.MMHD.FawryServices.payment;


import com.MMHD.FawryServices.Services.Service;
import com.MMHD.FawryServices.user.User;

public class Context {
    protected final Payment Current;
    public Context(Payment newStratgey) {Current = newStratgey;}

    public boolean pay(User user , Service service){
        return Current.pay(user,service);
    }

}