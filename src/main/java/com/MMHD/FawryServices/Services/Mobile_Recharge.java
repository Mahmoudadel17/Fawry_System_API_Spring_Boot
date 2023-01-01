package com.MMHD.FawryServices.Services;

import com.MMHD.FawryServices.ServiceProviders.CreateServiceProvider;
import com.MMHD.FawryServices.ServiceProviders.ServiceProvider;

public class Mobile_Recharge extends Service{
    public Mobile_Recharge(){
        super("Mobile Recharge");
        for (int i=1;i<=4;i++){
            createServiceProvider = new CreateServiceProvider();
            ServiceProvider serviceProvider = createServiceProvider.createServiceProvider(i);
            this.AddServiceProvider(serviceProvider);
        }

    }

    @Override
    public boolean checkDelivary() {
        return false;
    }

    @Override
    public void setAmount(long amoun) {
        amount=amoun;
    }
}
