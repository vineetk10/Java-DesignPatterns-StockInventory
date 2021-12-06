package Helper;

import Database.StockDatabase;

import java.util.HashSet;

public class CreditCard {
    private StockDatabase db =  StockDatabase.getInstance();

    public void PrintCreditCards()
    {
        HashSet<String> creditCards = db.getCreditCards();
        creditCards.add("5023 4512 7612 9087");
        creditCards.add("1234 5678 9101 4519");
        for(String card: creditCards)
        {
            if(card!=null)
                System.out.println(card);
        }
    }

}
