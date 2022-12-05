package CreatorServices;

import Services.Services;
import Services.We_internet_paymen;
public class We_internet_paymen_Dialog extends DialogServices{
    @Override
    public Services CreateService() {
        return new We_internet_paymen();
    }
}
