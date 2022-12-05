package UserP;

import AdminP.Request;
import Services.Services;

import java.util.LinkedList;

public class User {
	private String Name;
	private String MobileNumber;
	private String Email;
	private String Password;
	private Wallet wallet ;
    private Credit_Card creditCard;
	private final LinkedList<Services> AllServicesPay = new LinkedList<>();
	private final LinkedList<Request> AllRefundRequsets = new LinkedList<>();
	
	
	public User(){}
	public User(String userName ,String email,String password)
	{
	this.Name=userName;
	this.Email=email;
	this.Password=password;
	wallet = new Wallet();
	}
	public String getMobileNumber(){return this.MobileNumber;}
	public void setMobileNumber(String MOBILE){this.MobileNumber=MOBILE;}
	public String getUserName(){return this.Name;}
	public String getPassword(){return this.Password;}
	public String getEmail(){return this.Email;}

	public void AddRequest(Request request){
		AllRefundRequsets.add(request);
	}
	public LinkedList<Services> getAllServicesPay(){return AllServicesPay;}
	public LinkedList<Request> getAllRefundRequsets(){
		return AllRefundRequsets;
	}
	public void setCreditCard(Credit_Card creditCard) {
		this.creditCard=creditCard;
	}
	public Credit_Card getCreditCard() {
		return this.creditCard;
	}
	public Wallet getWallet() {
		return this.wallet;
	}
	public void AddService(Services service){
		AllServicesPay.add(service);
	}
	public void RemoveService(int index){
		AllServicesPay.remove(index);
	}


}
