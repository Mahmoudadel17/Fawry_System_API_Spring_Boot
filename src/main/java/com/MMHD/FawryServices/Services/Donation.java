package com.MMHD.FawryServices.Services;

import com.MMHD.FawryServices.ServiceProviders.CreateServiceProvider;
import com.MMHD.FawryServices.ServiceProviders.ServiceProvider;

public class Donation extends Service {
    public Donation(){
        super("Donation");
        createServiceProvider = new CreateServiceProvider();
        ServiceProvider serviceProvider = createServiceProvider.createServiceProvider(6);
        this.AddServiceProvider(serviceProvider);
    }

    @Override
    public boolean checkDelivary() {
        return true;
    }
    @Override
    public void setAmount(long amoun) {
        amount=amoun;
    }
}
