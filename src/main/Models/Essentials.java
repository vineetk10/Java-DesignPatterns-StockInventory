package Models;

public class Essentials extends Category{

    private int limit = 3;

    @Override
    public boolean IsLimitExceeded(double quantity)
    {
        return quantity>this.limit;
    }
}