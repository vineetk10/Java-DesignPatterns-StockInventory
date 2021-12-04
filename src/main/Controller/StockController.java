package Controller;

import Database.StockDatabase;
import Helper.FileHandler;
import Models.Category;
import Models.Item;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class StockController
{
    private static StockDatabase db =  StockDatabase.getInstance();

    private FileHandler file;

    public StockController(String filePath)
    {
        file = new FileHandler(filePath,"");
    }

    public void SaveStockInventory()
    {
        ArrayList<String> fileContent = new ArrayList<>();
        file.ReadFileContents(fileContent);
        SaveStocksInDb(fileContent);
    }

    public static void SaveStocksInDb(ArrayList<String> fileContent)
    {
        for(String items : fileContent)
        {
            if(items==null)
                continue;
            String[] item = items.split(",");
            Category category = Category.Create(item[0]);
            db.getItems().put(item[1], new Item(category,item[1], Integer.parseInt(item[2]),Double.parseDouble(item[3])));
        }
    }
}