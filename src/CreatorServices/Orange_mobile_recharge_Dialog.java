package CreatorServices;

import Services.Services;
import Services.Orange_mobile_recharge;
public class Orange_mobile_recharge_Dialog extends DialogServices{
    @Override
    public Services CreateService() {
        return new Orange_mobile_recharge();
    }
}
