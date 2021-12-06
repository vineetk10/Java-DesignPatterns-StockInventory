package ChainOfResponsibility;
import Database.StockDatabase;
import Models.Category;
import Models.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class CategoryLimitExceeded extends Validation{
    private StockDatabase db =  StockDatabase.getInstance();
    @Override
    public boolean operate(ValidationRequest request, HashMap<String,Integer> itemCount,HashMap<String,Integer> categoryCount) {

        String itemName = request.getItemName();
        Item item = db.getItems().get(itemName);
        Category category = item.getCategory();
        String categoryName = category.getCategoryName();
        ArrayList<String> outputMessage = request.getOutputMessage();
        int quantity = request.getQuantity();

        int newQuantity = categoryCount.containsKey(categoryName) ? categoryCount.get(categoryName) + quantity : quantity;
        categoryCount.put(categoryName, newQuantity);

        if(category.IsLimitExceeded(newQuantity))
        {
            outputMessage.add("Category limit exceeded for category "+categoryName);
            return false;
        }
        else
        {
            if(nextValidation!=null)
            {
                return nextValidation.operate(request,itemCount,categoryCount);
            }
            else
                return true;
        }

    }
}
