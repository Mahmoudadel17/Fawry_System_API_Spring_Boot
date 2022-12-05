package UserP;

import CreatorServices.CreateService;
import CreatorServices.DialogServices;
import Services.Services;

import java.lang.reflect.GenericArrayType;
import java.util.LinkedList;

public class SearchingList {
    private static LinkedList<Services> ServicesList ;

    private static void GenerateListServices(){

        ServicesList = new LinkedList<>();
        int i1=1,i2=2,i3=3,i4=4;
        DialogServices dialogService;
        for (int j=1;j<=4;j++){
            dialogService = CreateService.createservice(i1,j);
            Services service = dialogService.CreateService();
            ServicesList.add(service);
        }
        for (int j=1;j<=4;j++){
            dialogService = CreateService.createservice(i2,j);
            Services service = dialogService.CreateService();
            ServicesList.add(service);
        }for (int j=1;j<=2;j++){
            dialogService = CreateService.createservice(i3,j);
            Services service = dialogService.CreateService();
            ServicesList.add(service);
        }
        for (int j=1;j<=3;j++){
            dialogService = CreateService.createservice(i4,j);
            Services service = dialogService.CreateService();
            ServicesList.add(service);
        }


    }

    public static LinkedList<Services> Search(String match) {
        GenerateListServices();
        LinkedList<Services> matchServices = new LinkedList<>();
        for (int i=0;i<ServicesList.size();i++){
            if (ServicesList.get(i).getName().contains(match)){
                matchServices.add(ServicesList.get(i));
            }
        }

        return matchServices;
    }
}
