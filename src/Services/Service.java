package Services;

import java.util.LinkedList;

public abstract class Service {
    private final String ServiceName;
    private long Amount;
    public Service(String serviceName){
        this.ServiceName=serviceName;
    }
    private final LinkedList<ServiceProvider> AllServicesProvider = new LinkedList<>();

    public void AddServiceProvider(ServiceProvider serviceProvider){AllServicesProvider.add(serviceProvider);}

    public LinkedList<ServiceProvider> getAllServicesProvider(){return AllServicesProvider;}

    public abstract boolean checkDelivary();
    public void setAmount(long amount){this.Amount=amount;}
    public long getAmount(){return  Amount;}
    public String getName(){return ServiceName;}

}
