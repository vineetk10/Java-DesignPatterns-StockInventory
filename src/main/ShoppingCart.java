import Controller.OrderController;
import Controller.StockController;
import Database.StockDatabase;

import java.io.*;
import java.nio.*;
import java.util.Scanner;

public class ShoppingCart {

    private StockDatabase db =  StockDatabase.getInstance();

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file path of stock inventory");
        String stockFilePath = sc.nextLine();

        StockController stockController = new StockController(stockFilePath);
        stockController.SaveStockInventory();

        System.out.println("Enter the file path of orders");
        String orderFilePath = sc.nextLine();

        System.out.println("Enter the file path where you want the output");
        String outputFilePath = sc.nextLine();

        OrderController orderController = new OrderController(orderFilePath,outputFilePath);
        orderController.EvaluateOrders();

    }


}