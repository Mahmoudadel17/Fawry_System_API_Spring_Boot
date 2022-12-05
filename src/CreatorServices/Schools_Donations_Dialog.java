package CreatorServices;

import Services.Services;
import Services.Schools_Donations;
public class Schools_Donations_Dialog extends DialogServices{
    @Override
    public Services CreateService() {
        return new Schools_Donations();
    }
}
