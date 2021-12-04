package Models;

public abstract class Category
{
    public static Category Create(String itemName)
    {
        return switch (itemName) {
            case "Essentials" -> new Essentials();
            case "Luxury" -> new Luxury();
            default -> new Misc();
        };
    }

    public abstract boolean IsLimitExceeded(double quantity);
}