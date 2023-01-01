package com.MMHD.FawryServices.Search;


import com.MMHD.FawryServices.CreatorServices.Create_Service;
import com.MMHD.FawryServices.CreatorServices.DialogService;
import com.MMHD.FawryServices.Services.Service;


import java.util.LinkedList;

public class SearchingList {
    private static LinkedList<Service> ServicesList ;

    private static void GenerateListServices(){

        ServicesList = new LinkedList<>();
        Create_Service createService = new Create_Service();
        DialogService dialogService;
        for (int j=1;j<=4;j++){
            dialogService = createService.CreateService(j);
            Service service = dialogService.CreateService();
            ServicesList.add(service);
        }


    }

    public  LinkedList<Service> Search(String match) {
        GenerateListServices();
        LinkedList<Service> matchServices = new LinkedList<>();
        match = match.toLowerCase();
        for (Service service : ServicesList) {
            if (service.getName().toLowerCase().contains(match)) {
                matchServices.add(service);
            }
        }

        return matchServices;
    }
    public  LinkedList<Service> getServicesList(){
        GenerateListServices();
        return ServicesList;
    }
}
