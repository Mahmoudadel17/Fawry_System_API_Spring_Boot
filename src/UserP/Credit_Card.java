package UserP;

public class Credit_Card {

	private String Cardholder_name;
	private String Card_number;
	private String Expiration_date;
	private String CVV;
	private long money_balance=1000;// assume that user has 1000 Pound
	public Credit_Card(String s1,String s2,String s3,String s4){
		this.Cardholder_name=s1;
		this.Card_number=s2;
		this.Expiration_date=s3;
		this.CVV=s4;
	}
	public long getbalance() {return this.money_balance;}
	public void use_credit_money(long amount) {
		this.money_balance-=amount;
	}
	
	
}
