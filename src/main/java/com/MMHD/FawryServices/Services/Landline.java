package com.MMHD.FawryServices.Services;

import com.MMHD.FawryServices.ServiceProviders.CreateServiceProvider;
import com.MMHD.FawryServices.ServiceProviders.ServiceProvider;

public class Landline extends Service{
    public Landline(){
        super("Landline");
        createServiceProvider = new CreateServiceProvider();
        ServiceProvider serviceProvider = createServiceProvider.createServiceProvider(5);
        this.AddServiceProvider(serviceProvider);
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
