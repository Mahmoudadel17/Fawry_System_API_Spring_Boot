package CreatorServices;

import Services.Services;
import Services.We_mobile_recharge;
public class We_mobile_recharge_Dialog extends DialogServices{
    @Override
    public Services CreateService() {
        return new We_mobile_recharge();
    }
}
