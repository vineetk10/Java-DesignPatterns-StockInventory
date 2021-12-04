
package Database;

import Models.Item;

import java.util.HashMap;
import java.util.HashSet;

public class StockDatabase
{
    private static StockDatabase instance;
    private HashMap<String, Item> items = new HashMap<>();
    private HashSet<String> creditCards = new HashSet<>();

    private StockDatabase() {}

    public static StockDatabase getInstance()
    {
        if(instance==null)
            instance = new StockDatabase();

        return instance;
    }

    public HashMap<String, Item> getItems() {
        return items;
    }

    public HashSet<String> getCreditCards() {
        return creditCards;
    }
}