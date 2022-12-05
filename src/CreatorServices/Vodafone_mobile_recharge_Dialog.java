package CreatorServices;

import Services.Services;
import Services.Vodafone_mobile_recharge;
public class Vodafone_mobile_recharge_Dialog extends DialogServices{
    @Override
    public Services CreateService() {
        return new Vodafone_mobile_recharge();
    }
}
