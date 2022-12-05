package AdminP;

import java.util.LinkedList;

public class Admin {
    private static final LinkedList<Request> AllRequest = new LinkedList<>();

    public static void AddRequest(Request request){
        AllRequest.add(request);
        System.out.println(" successful Send Request to Admin ");
    }
    public static Request getRemovedRequest(int i){
        return AllRequest.remove(i);
    }
    public static void RemoveRequest(int i){
        AllRequest.remove(i);
    }

    public static LinkedList<Request> getAllRequest(){return AllRequest;}


}
