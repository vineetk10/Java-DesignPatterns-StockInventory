package Models;

public class Luxury extends Category{

    private int limit = 3;
    private String CategoryName = "Luxury";
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