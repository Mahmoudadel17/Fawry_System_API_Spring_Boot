package transactions;

import Services.Service;
import user.User;

public class Payment_transaction extends transaction{
    private final Service service;
    public Payment_transaction(User user, Service service){
        super(user);
        this.service=service;

    }

    public Service getPaymentServiceTransaction(){return service;}
}
