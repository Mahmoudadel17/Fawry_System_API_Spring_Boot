package Search;

import CreatorServices.DialogService;
import CreatorServices.Create_Service;
import Services.Service;

import java.util.LinkedList;

public class SearchingList {
    private static LinkedList<Service> ServicesList ;

    private static void GenerateListServices(){

        ServicesList = new LinkedList<>();
        Create_Service createService = new Create_Service();
        int i1=1,i2=2,i3=3,i4=4;
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
        for (Service service : ServicesList) {
            if (service.getName().contains(match)) {
                matchServices.add(service);
            }
        }

        return matchServices;
    }
}
