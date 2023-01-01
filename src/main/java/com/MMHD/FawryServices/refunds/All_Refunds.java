package com.MMHD.FawryServices.refunds;

import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class All_Refunds {
    private  final LinkedList<Request> AllRequest = new LinkedList<>();

    public void AddRequest(Request request){
        AllRequest.add(request);
        System.out.println(" successful Send Request to Admin ");
    }
    public  Request getRemovedRequest(int i){
        return AllRequest.remove(i);
    }
    public  void RemoveRequest(int i){
        AllRequest.remove(i);
    }

    public  LinkedList<Request> getAllRequest(){return AllRequest;}

}
