package CreatorServices;

import Services.Donation;
import Services.Service;

public class Donation_Dialog extends DialogService{

    @Override
    public Service CreateService() {
        return new Donation();
    }
}
