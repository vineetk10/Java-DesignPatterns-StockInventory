package ChainOfResponsibility;

import java.util.HashMap;

public abstract class Validation {
    protected Validation nextValidation;

    public void setNext(Validation next)
    {
        this.nextValidation = next;
    }

    public abstract boolean operate(ValidationRequest request, HashMap<String,Integer> itemCount,HashMap<String,Integer> categoryCount);
}
