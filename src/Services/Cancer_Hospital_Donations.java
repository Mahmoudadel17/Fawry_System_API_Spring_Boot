package Services;

public class Cancer_Hospital_Donations implements Services{
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
        return "donations cancer hospital ";
    }
}
