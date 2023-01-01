package com.MMHD.FawryServices.ServiceProviders;


import java.util.LinkedList;

public class CreateServiceProvider {
    static ServiceProvider serviceProvider;
    private static LinkedList<ServiceProvider> ServicesProviderList ;
    public ServiceProvider createServiceProvider(int c){
        if (c==1){
            Form VdafoneForm = new VodafoneForm();
            serviceProvider = new ServiceProvider("Vodafone",VdafoneForm);
        }else  if (c==2){
            Form EtisalatForm = new EtisalatForm();
            serviceProvider = new ServiceProvider("Etisalat",EtisalatForm);
        }
        else  if (c==3){
            Form OrangeForm = new OrangeForm();
            serviceProvider = new ServiceProvider("Orange",OrangeForm);
        }
        else  if (c==4){
            Form WeForm = new WeForm();
            serviceProvider = new ServiceProvider("We",WeForm);
        }
        else  if (c==5){
            Form LandlineForm = new LandlineForm();
            serviceProvider = new ServiceProvider("Landline",LandlineForm);
        }
        else  if (c==6){
            Form DonationForm = new DonationForm();
            serviceProvider = new ServiceProvider("Donation",DonationForm);
        }
        return serviceProvider;
    }



}
