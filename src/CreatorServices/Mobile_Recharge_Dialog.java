package CreatorServices;

import Services.Mobile_Recharge;
import Services.Service;

public class Mobile_Recharge_Dialog extends DialogService{
    @Override
    public Service CreateService() {
        return new Mobile_Recharge();
    }
}
