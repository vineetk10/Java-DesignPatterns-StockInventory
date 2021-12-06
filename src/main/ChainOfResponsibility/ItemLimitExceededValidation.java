package ChainOfResponsibility;

import Database.StockDatabase;
import Models.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemLimitExceededValidation extends Validation{

    private StockDatabase db =  StockDatabase.getInstance();
    @Override
    public boolean operate(ValidationRequest request, HashMap<String,Integer> itemCount,HashMap<String,Integer> categoryCount) {

        String itemName = request.getItemName();
        ArrayList<String> outputMessage = request.getOutputMessage();
        int quantity = request.getQuantity();
        Item item = db.getItems().get(itemName);
        int newItemQuantity = itemCount.containsKey(itemName) ? itemCount.get(itemName) + quantity : quantity;
        itemCount.put(itemName, newItemQuantity);

        if(itemCount.get(itemName)>item.getQuantity())
        {
            outputMessage.add("Stock limit exceeded for item "+itemName+" with quantity "+quantity);
            return false;
        }
        else
        {
            if(nextValidation!=null)
            {
               return nextValidation.operate(request,itemCount,categoryCount);
            }
            return true;

        }

    }
}
