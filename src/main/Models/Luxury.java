package Models;

public class Luxury extends Category{

    private int limit = 4;

    @Override
    public boolean IsLimitExceeded(double quantity)
    {
        return quantity>this.limit;
    }
}