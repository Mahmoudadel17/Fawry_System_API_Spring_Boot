package CreatorServices;

import Services.Services;
import Services.Orange_internet_paymen;
public class Orange_internet_paymen_Dialog extends DialogServices {
    @Override
    public Services CreateService() {
        return new Orange_internet_paymen();
    }
}
