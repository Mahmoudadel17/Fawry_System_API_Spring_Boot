package UserP;

import Services.Services;

import java.util.LinkedList;

public class User {
	private String Name;
	private String Email;
	private String Password;
	private Wallet wallet ;
    private Credit_Card creditCard;
	private static final LinkedList<Services> AllServicesPay = new LinkedList<>();
	
	
	
	public User(){}
	public User(String userName ,String email,String password)
	{
	this.Name=userName;
	this.Email=email;
	this.Password=password;
	wallet = new Wallet();
	}
	public String getUserName(){return this.Name;}
	public String getPassword(){return this.Password;}
	public String getEmail(){return this.Email;}
	 
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

}
