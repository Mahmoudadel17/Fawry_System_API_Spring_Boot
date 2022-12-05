package Services;

public class NGOs_Donations implements Services {
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
        return true;
    }
    @Override
    public String getName() {
        return "donations NGOs, non profitable organizations";
    }
}
