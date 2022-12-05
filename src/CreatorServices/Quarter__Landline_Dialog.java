package CreatorServices;

import Services.Services;
import Services.Quarter__Landline;
public class Quarter__Landline_Dialog extends DialogServices{
    @Override
    public Services CreateService() {
        return new Quarter__Landline();
    }
}
