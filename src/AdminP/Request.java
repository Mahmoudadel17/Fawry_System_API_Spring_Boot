package AdminP;

import Services.Services;
import UserP.User;

public class Request {
	private Services service;
	private int ServicesId;
	private User user;
	private String State="waiting";//( waiting , accepted , rejected) , every refund in start -> waiting
	public Request(Services service,User user,int id){
		this.service = service;
		this.user = user;
		this.ServicesId=id;
		
	}
	public Services getService(){return service;}
	public User getUser(){return user;}
	public int getServicesId(){
		return ServicesId;
	}
	public String getState(){return State;}
	public void setState_Accepted() {this.State="accepted";}
	public void setState_Rejected() {this.State="rejected";}
	
	

}
