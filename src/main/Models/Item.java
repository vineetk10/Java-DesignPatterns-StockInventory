package Models;

public class Item
{
    private Category category;
    private String name;
    private int quantity;
    private double price;

    public Item(Category category, String name, int quantity, double price)
    {
        this.category = category;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity()
    {
        return this.quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public double getPrice()
    {
        return this.price;
    }

    public Category getCategory()
    {
        return this.category;
    }
}