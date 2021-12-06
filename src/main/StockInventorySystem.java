import Controller.OrderController;
import Controller.StockController;
import Database.StockDatabase;
import Helper.CreditCard;

import java.io.*;
import java.nio.*;
import java.util.HashSet;
import java.util.Scanner;

public class StockInventorySystem {

    private StockDatabase db =  StockDatabase.getInstance();

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file path of stock inventory");
        String stockFilePath = sc.nextLine();

        StockController stockController = new StockController(stockFilePath);
        stockController.SaveStockInventory();

        System.out.println("Enter the file path where you want all the output files");
        String outputFilePath = sc.nextLine();

        String orderFilePath;


        while(true) {
            System.out.println("Enter the file path of orders. Type exit if no more input file");
            orderFilePath = sc.nextLine();
            if (orderFilePath.equals("exit"))
                break;
            OrderController orderController = new OrderController(orderFilePath, outputFilePath);
            orderController.EvaluateOrders();
            CreditCard creditCard = new CreditCard();
            creditCard.PrintCreditCards();
        }

        System.out.println("Thank You!");
    }

}