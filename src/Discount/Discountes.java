package Discount;

import Services.Services;

public class Discountes implements Services {
    private Services service;
   
    Discountes(Services service){
        this.service=service;
    }

    
    @Override
    public void setAmount(long amount) {
        service.setAmount(amount);
    }

    @Override
    public long getAmount() {
        return service.getAmount();
    }

    @Override
    public boolean checkDelivary() {
        return service.checkDelivary();
    }

    @Override
    public String getName() {
        return service.getName();
    }
}
