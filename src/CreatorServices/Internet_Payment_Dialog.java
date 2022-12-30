package CreatorServices;

import Services.Internet_Payment;
import Services.Service;

public class Internet_Payment_Dialog extends DialogService{
    @Override
    public Service CreateService() {
        return new Internet_Payment();
    }
}
