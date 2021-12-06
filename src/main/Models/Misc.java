package Models;

public class Misc extends Category{

    private int limit = 6;
    private String CategoryName = "Misc";
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