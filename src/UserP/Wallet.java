package UserP;

public class Wallet {
	private long money_balance_Wallet;
	
	public void add_to_wallet(long money) {
		this.money_balance_Wallet+=money;
	}
	public void use_wallet_money(long amount) {
		this.money_balance_Wallet-=amount;
	}
	public long wallet_money() {
		return money_balance_Wallet;
	}
	
	

}
