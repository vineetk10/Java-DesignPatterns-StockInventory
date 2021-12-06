package Models;

public class Essentials extends Category{

    private int limit = 5;
    private String CategoryName = "Essentials";

    @Override
    public boolean IsLimitExceeded(double quantity)
    {
        return quantity>this.limit;
    }

    @Override
    public String getCategoryName()
    {
        return this.CategoryName;
    }
}