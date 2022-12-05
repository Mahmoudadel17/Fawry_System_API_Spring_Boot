package CreatorServices;

import Services.Services;
import Services.Etisalat_internet_payment;
public class Etisalat_internet_payment_Dialog extends DialogServices{
    @Override
    public Services CreateService() {
        return new Etisalat_internet_payment();
    }
}
