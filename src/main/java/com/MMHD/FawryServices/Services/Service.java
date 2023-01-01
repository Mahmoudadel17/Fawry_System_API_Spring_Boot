package com.MMHD.FawryServices.Services;

import com.MMHD.FawryServices.ServiceProviders.CreateServiceProvider;
import com.MMHD.FawryServices.ServiceProviders.ServiceProvider;

import java.util.LinkedList;

public abstract class Service {
    private final String ServiceName;
    protected long amount;
    private boolean checkRef=false;
    CreateServiceProvider createServiceProvider ;
    public Service(String serviceName){
        this.ServiceName=serviceName;
    }
    private final LinkedList<ServiceProvider> AllServicesProvider = new LinkedList<>();

    public void AddServiceProvider(ServiceProvider serviceProvider){AllServicesProvider.add(serviceProvider);}

    public LinkedList<ServiceProvider> getAllServicesProvider(){return AllServicesProvider;}

    public abstract boolean checkDelivary();
    public abstract void setAmount(long amount);
    public long getAmount(){return  amount;}
    public void setCheckRef(){
        this.checkRef=true;
    }

    public boolean isCheckRef() {
        return checkRef;
    }

    public String getName(){return ServiceName;}

}
