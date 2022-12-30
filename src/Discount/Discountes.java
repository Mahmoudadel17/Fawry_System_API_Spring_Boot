package Discount;

import Services.Service;

public class Discountes extends Service{
    private Service service;

    Discountes(Service service){
        super(service.getName());
        this.service=service;

    }

    @Override
    public boolean checkDelivary() {
        return service.checkDelivary();
    }
}
