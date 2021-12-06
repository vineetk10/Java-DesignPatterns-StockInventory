package Controller;

import ChainOfResponsibility.CategoryLimitExceeded;
import ChainOfResponsibility.ItemLimitExceededValidation;
import ChainOfResponsibility.ValidationRequest;
import Database.StockDatabase;
import Helper.FileHandler;
import Iterator.FileRepository;
import Iterator.Iterator;
import Models.Category;
import Models.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderController
{
    private StockDatabase db =  StockDatabase.getInstance();
    private FileHandler file;
    private HashMap<String,Integer> categoryCount = new HashMap<>();
    private HashMap<String,Integer> itemCount = new HashMap<>();

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

    private boolean IsValidOrder(String itemName, int quantity,ArrayList<String> outputMessage)
    {
        if(!db.getItems().containsKey(itemName))
        {
            outputMessage.add("No item in inventory for item "+itemName+" with quantity "+quantity);
            return false;
        }
        ItemLimitExceededValidation itemLimitExceededValidation = new ItemLimitExceededValidation();
        CategoryLimitExceeded categoryLimitExceeded = new CategoryLimitExceeded();
        itemLimitExceededValidation.setNext(categoryLimitExceeded);

        ValidationRequest validationRequest = new ValidationRequest(itemName,quantity,outputMessage);
        return itemLimitExceededValidation.operate(validationRequest,itemCount,categoryCount);
    }
}
