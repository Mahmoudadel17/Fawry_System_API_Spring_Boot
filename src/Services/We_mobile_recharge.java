package Services;

public class We_mobile_recharge implements Services{
    private long Amount;
    @Override
    public void setAmount(long amount) {
        this.Amount = amount;
    }

    @Override
    public long getAmount() {
        return this.Amount;
    }
    @Override
    public boolean checkDelivary() {
        return false;
    }
    @Override
    public String getName() {
        return "mobile recharge we";
    }
}
