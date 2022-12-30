package Search;
import Services.Service;

import java.util.LinkedList;

public class FawrySearchCtl {
    public LinkedList<Service> Search_About_Service(String NameService) {
        SearchingList searchingList = new SearchingList();
        return searchingList.Search(NameService);
    }
}
