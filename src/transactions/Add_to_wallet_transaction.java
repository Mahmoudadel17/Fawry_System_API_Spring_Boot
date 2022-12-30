package transactions;

import user.User;

public class Add_to_wallet_transaction extends transaction{
    private final long Amount;
    public Add_to_wallet_transaction(User user,long amount){
        super(user);
        this.Amount=amount;

    }
    public long getAddWalletAmountTransaction(){return Amount;}
}
