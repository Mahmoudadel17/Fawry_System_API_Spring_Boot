package com.MMHD.FawryServices.CreatorServices;

public class Create_Service {
    DialogService dialogService;
    public DialogService CreateService(int c){
        if (c==1){
            dialogService = new Mobile_Recharge_Dialog();
        }else if (c==2){
            dialogService = new Internet_Payment_Dialog();
        }else if (c==3){
            dialogService = new Landline_Dialog();
        }else if (c==4){
            dialogService = new Donation_Dialog();
        }else{
            // will handle
            System.out.println("no service in this number select");
            return null;
        }
        return dialogService;
    }
}
