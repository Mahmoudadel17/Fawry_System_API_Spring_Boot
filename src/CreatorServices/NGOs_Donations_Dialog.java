package CreatorServices;

import Services.Services;
import Services.NGOs_Donations;
public class NGOs_Donations_Dialog extends DialogServices{
    @Override
    public Services CreateService() {
        return new NGOs_Donations();
    }
}
