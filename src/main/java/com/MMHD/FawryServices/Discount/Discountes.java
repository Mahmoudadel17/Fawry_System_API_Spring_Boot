package com.MMHD.FawryServices.Discount;


import com.MMHD.FawryServices.Services.Service;

public class Discountes extends Service{
    private final Service service;

    Discountes(Service service){
        super(service.getName());
        this.service=service;
    }

    @Override
    public boolean checkDelivary() {
        return service.checkDelivary();
    }

    @Override
    public void setAmount(long amoun) {
        service.setAmount(amoun);
    }

    public long getAmount() {
        return service.getAmount();
    }
}
