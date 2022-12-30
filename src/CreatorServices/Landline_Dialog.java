package CreatorServices;

import Services.Internet_Payment;
import Services.Landline;
import Services.Service;

public class Landline_Dialog extends DialogService{
    @Override
    public Service CreateService() {
        return new Landline();
    }
}
