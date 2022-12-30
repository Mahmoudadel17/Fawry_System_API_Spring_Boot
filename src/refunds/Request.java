package refunds;


import Services.Service;
import user.User;

public class Request {
    private Service service;
    private int ServicesId;
    private User user;
    private String State="waiting";//( waiting , accepted , rejected) , every refund in start -> waiting
    public Request(Service service,User user,int id){
        this.service = service;
        this.user = user;
        this.ServicesId=id;

    }
    public Service getService(){return service;}
    public User getUser(){return user;}
    public int getServicesId(){
        return ServicesId;
    }
    public String getState(){return State;}
    public void setState_Accepted() {this.State="accepted";}
    public void setState_Rejected() {this.State="rejected";}



}

