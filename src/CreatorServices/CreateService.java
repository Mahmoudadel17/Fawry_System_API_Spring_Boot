package CreatorServices;

public class CreateService {

    static DialogServices dialogServices;
    public static DialogServices createservice(int c1, int c2){
        // 1 >  Mobile recharge services.
        if (c1==1){
            if (c2==1){dialogServices = new Vodafone_mobile_recharge_Dialog();}
            else if(c2==2){dialogServices = new Etisalat_mobile_recharge_Dialog();}
            else if(c2==3){dialogServices = new Orange_mobile_recharge_Dialog();}
            else if(c2==4){dialogServices = new We_mobile_recharge_Dialog();}
        }
        // Internet Payment services.
        else if (c1==2){
            if (c2==1){dialogServices = new Vodafone_internet_paymen_Dialog();}
            else if(c2==2){dialogServices = new Etisalat_internet_payment_Dialog();}
            else if(c2==3){dialogServices = new Orange_internet_paymen_Dialog();}
            else if(c2==4){dialogServices = new We_internet_paymen_Dialog();}
        }
        // Landline services.
        else if (c1==3){
            if (c2==1){dialogServices = new Monthly_receipt_Landline_Dialog();}
            else if(c2==2){dialogServices = new Quarter__Landline_Dialog();}

        }
        // Donations.
        else if (c1==4){
            if (c2==1){dialogServices = new Cancer_Hospital_Donations_Dialog();}
            else if(c2==2){dialogServices = new Schools_Donations_Dialog();}
            else if(c2==3){dialogServices = new NGOs_Donations_Dialog();}

        }

        return dialogServices;
    }
}
