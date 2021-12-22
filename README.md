# StockInventory System

## How to run the application

1. On running the applicaton, the user will be prompted to enter the path of stock input file (Dataset.csv).
2. Then the user will be prompted to specify the path where he/she wants to store the output/error file.
3. Then the user will be continuously be prompted to enter the path of the order input file (InputFile.csv) until he/she types exit. 
4. The system will validate the order items and generate an error file if it encounters any problems.
5. If no errors were found, the system will create a success file with the total amount spent.

# Design Patterns Used


* Factory Design Pattern - 
  * Abstract Class Category, Class Essentials, Class Item, Class Luxury
  * Interface OutputFile, Class ErrorFile, Class SuccessFile and Clas FileHandler
![image](https://user-images.githubusercontent.com/26499781/144791041-5f4df16b-5d5a-46bb-a13f-9e509b2c5953.png)
![image](https://user-images.githubusercontent.com/26499781/144791062-051b6ae2-ad94-4ca5-923a-538462f03d52.png)
![image](https://user-images.githubusercontent.com/26499781/144791072-06484de5-675d-4e74-8449-a9d0ba62a03b.png)
![image](https://user-images.githubusercontent.com/26499781/144791084-235b2056-36e2-4a5c-aafe-b093384f64a2.png)
![image](https://user-images.githubusercontent.com/26499781/144790959-1c61424e-dc66-4445-a125-1fd39de874d6.png)

* Iterator Pattern - CLass FileRepository, Class Container, Class Iterator, Class OrderController
 ![image](https://user-images.githubusercontent.com/26499781/144791141-7856e1a2-015e-452e-ae73-bb001df685d4.png)
![image](https://user-images.githubusercontent.com/26499781/144791152-263bc1bf-c6c8-4b04-b34a-554687df058c.png)
![image](https://user-images.githubusercontent.com/26499781/144791176-f2d5b15d-698d-4c74-bc17-8425faa8da51.png)
![image](https://user-images.githubusercontent.com/26499781/144791199-4fdf395b-bf11-49f1-b6b3-21f8348f6834.png)

* Chain Of Responsibility Pattern - Class CategoryLimitExceededValidation, Class ItemLimitExceededValidation, Class Validation, Class ValidationRequest, Class OrderController
![image](https://user-images.githubusercontent.com/26499781/144791230-a0c8d58d-55ba-4777-925d-3b643ee8258a.png)
![image](https://user-images.githubusercontent.com/26499781/144791249-7ea801b6-cb19-4f2c-8ab1-c650929b51ee.png)
![image](https://user-images.githubusercontent.com/26499781/144791275-b085c209-82e4-42ca-ac58-a24821f4fb8b.png)
![image](https://user-images.githubusercontent.com/26499781/144791289-f8240065-2444-483e-b572-bc002558ca94.png)

* Singleton Design Pattern - Class StockDatabase
![image](https://user-images.githubusercontent.com/26499781/144791314-b75c0550-f281-4d30-bcc0-dd3a47762dad.png)


# Class Diagram


![StockInventoryCD](https://user-images.githubusercontent.com/26499781/144785513-b5eb3103-6806-4549-a929-f58b73c5215a.png)

# Screenshots of running code

* Output of input file 1

<img width="1440" alt="Screen Shot 2021-12-05 at 9 06 24 PM" src="https://user-images.githubusercontent.com/26499781/144790567-66f3b355-f3d4-45a2-9f40-0cc1e85a0b91.png">


* Output of input file 2

<img width="1440" alt="Screen Shot 2021-12-05 at 9 06 58 PM" src="https://user-images.githubusercontent.com/26499781/144790584-89491b91-d840-4972-9678-15dafcc68ec8.png">

* Output of file 3

<img width="1440" alt="Screen Shot 2021-12-05 at 9 07 23 PM" src="https://user-images.githubusercontent.com/26499781/144790608-df64861f-44ef-466f-9592-caaf5364a19e.png">


* Output of ending the program

<img width="1440" alt="Screen Shot 2021-12-05 at 9 08 23 PM" src="https://user-images.githubusercontent.com/26499781/144790620-547a8ea0-8b74-4e71-9b17-b9cc07f83689.png">

