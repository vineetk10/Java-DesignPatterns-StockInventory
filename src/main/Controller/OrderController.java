package Controller;

import Database.StockDatabase;
import Helper.FileHandler;
import Iterator.FileRepository;
import Iterator.Iterator;
import Models.Category;
import Models.Item;

import java.util.ArrayList;

public class OrderController
{
    private static StockDatabase db =  StockDatabase.getInstance();
    private FileHandler file;

    public OrderController(String filePath, String outputFilePath)
    {
        file = new FileHandler(filePath,outputFilePath);
    }
    public void EvaluateOrders()
    {
        ArrayList<String> outputMessage = new ArrayList<>();
        ArrayList<String> fileContent = new ArrayList<>();
        file.ReadFileContents(fileContent);
        GetTotalAmount(fileContent,outputMessage);
    }

    private void GetTotalAmount(ArrayList<String> fileContent,ArrayList<String> outputMessage)
    {
        boolean isError = false;
        double totalAmount = 0;
        FileRepository fileRepository = new FileRepository(fileContent);
        for(Iterator iter = fileRepository.getIterator(); iter.hasNext();)
        {
            Object val = iter.next();
            if(val==null)
                continue;
            String[] item = ((String)val).split(",");
            String itemName = item[0];
            int quantity = Integer.parseInt(item[1]);
            String creditCardNo = item[2];

            if(IsValidOrder(item[0],quantity,outputMessage))
            {
                Item it = db.getItems().get(itemName);
                totalAmount += it.getPrice()*quantity;
                it.setQuantity(it.getQuantity()-quantity);
                db.getCreditCards().add(creditCardNo);
            }
            else
            {
                isError = true;
                GenerateErrorTextFile(outputMessage);
            }
        }
        if(!isError)
         PrintOrder(totalAmount,outputMessage);
    }

    private void PrintOrder(double totalAmount,ArrayList<String> outputMessage)
    {
        outputMessage.add("Amt Paid");
        outputMessage.add(Double.toString(totalAmount));
        try
        {
            file.writeOutput(outputMessage,false);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void GenerateErrorTextFile(ArrayList<String> outputMessage)
    {
        if(outputMessage.isEmpty())
        {
            try
            {
                file.writeOutput(outputMessage,true);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            try
            {
                file.writeOutput(outputMessage,true);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }

    }

    private static boolean IsValidOrder(String itemName, int quantity,ArrayList<String> outputMessage)
    {
        if(!db.getItems().containsKey(itemName))
        {
            outputMessage.add("Stock limit exceeded for item "+itemName+" with quantity "+quantity);
            return false;
        }

        Item item = db.getItems().get(itemName);

        if(quantity>item.getQuantity())
        {
            outputMessage.add("Stock limit exceeded for item "+itemName+" with quantity "+quantity);
            return false;
        }
        Category type = Category.Create(itemName);
        if(type.IsLimitExceeded(quantity))
        {
            outputMessage.add("Category limit exceeded for item "+itemName+" with quantity "+quantity);
            return false;
        }
        return true;
    }
}
