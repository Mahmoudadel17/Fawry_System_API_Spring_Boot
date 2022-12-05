package CreatorServices;


import Services.Cancer_Hospital_Donations;
import Services.Services;

public class Cancer_Hospital_Donations_Dialog extends DialogServices{
    @Override
    public Services CreateService() {
        return new Cancer_Hospital_Donations();
    }
}

