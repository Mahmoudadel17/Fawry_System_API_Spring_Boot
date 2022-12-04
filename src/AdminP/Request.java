package AdminP;

public class Request {
	private String ServiceName;
	private long Amount;
	private String State="waiting";//( waiting , accepted , rejected) , every refund in start -> waiting
	public Request(String SName,long amount){
		this.ServiceName=SName;
		this.Amount=amount;
		
	}
	public void setState_Accepted() {this.State="accepted";}
	public void setState_Rejected() {this.State="rejected";}
	
	

}
