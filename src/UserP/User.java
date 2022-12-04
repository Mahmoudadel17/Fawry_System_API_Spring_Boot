package UserP;

public class User {
	private String Name;
	private String Email;
	private String Password;
	private Wallet wallet ;
    private Credit_Card creditCard;
	
	
	
	public User(){}
	public User(String userName ,String email,String password)
	{
	this.Name=userName;
	this.Email=email;
	this.Password=password;
	}
	public String getUserName(){return this.Name;}
	public String getPassword(){return this.Password;}
	public String getEmail(){return this.Email;}

	

}
