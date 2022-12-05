package CreatorServices;

import Services.Services;
import Services.Monthly_receipt_Landline;
public class Monthly_receipt_Landline_Dialog extends DialogServices{
    @Override
    public Services CreateService() {
        return new Monthly_receipt_Landline();
    }
}
