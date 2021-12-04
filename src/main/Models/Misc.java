package Models;

public class Misc extends Category{

    private int limit = 6;

    @Override
    public boolean IsLimitExceeded(double quantity)
    {
        return quantity>this.limit;
    }
}