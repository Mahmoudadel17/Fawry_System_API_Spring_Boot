package CreatorServices;

import Services.Services;
import Services.Vodafone_internet_paymen;
public class Vodafone_internet_paymen_Dialog extends DialogServices{
    @Override
    public Services CreateService() {
        return new Vodafone_internet_paymen();
    }
}
