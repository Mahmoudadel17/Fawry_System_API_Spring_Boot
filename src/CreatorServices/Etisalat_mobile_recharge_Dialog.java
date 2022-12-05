package CreatorServices;

import Services.Etisalat_mobile_recharge;
import Services.Services;
public class Etisalat_mobile_recharge_Dialog extends DialogServices {
    @Override
    public Services CreateService() {
        return new Etisalat_mobile_recharge();
    }
}
