package ChainOfResponsibility;

import java.util.ArrayList;
import java.util.HashMap;

public class ValidationRequest {
    private String itemName;
    private int quantity;
    private ArrayList<String> outputMessage;

    public ValidationRequest(String itemName, int quantity, ArrayList<String> outputMessage)
    {
        this.itemName = itemName;
        this.outputMessage = outputMessage;
        this.quantity = quantity;
    }

    public String getItemName()
    {
        return this.itemName;
    }

    public int getQuantity()
    {
        return this.quantity;
    }

    public ArrayList<String> getOutputMessage()
    {
        return this.outputMessage;
    }
}
