package Models;

public abstract class Category
{
    public static Category Create(String categoryName)
    {
        return switch (categoryName) {
            case "Essential" -> new Essentials();
            case "Luxury" -> new Luxury();
            default -> new Misc();
        };
    }

    public abstract boolean IsLimitExceeded(double quantity);

    public abstract String getCategoryName();
}