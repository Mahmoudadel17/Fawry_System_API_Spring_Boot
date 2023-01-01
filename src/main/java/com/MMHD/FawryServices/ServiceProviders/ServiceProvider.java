package com.MMHD.FawryServices.ServiceProviders;


public class ServiceProvider {
    private final String serviceProviderName;
    private final Form form;

    public ServiceProvider(String serviceProviderName,Form form){
        this.serviceProviderName=serviceProviderName;
        this.form=form;

    }
    public String getServiceProviderName() {
        return serviceProviderName;
    }

    public Form get_form() {
        return form;
    }

}
