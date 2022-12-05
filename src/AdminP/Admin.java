package AdminP;

import UserP.User;

import java.util.LinkedList;

public class Admin {
    private static final LinkedList<Request> AllRequest = new LinkedList<>();

    public void AddRequest(Request request){
        AllRequest.add(request);
        System.out.println(" successful Add Request ");
    }


}
