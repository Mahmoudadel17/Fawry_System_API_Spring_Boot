package Services;

public class Etisalat_internet_payment implements Services{
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
        return "internet payment etisalat";
    }
}
