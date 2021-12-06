# StockInventory System

Name: Vineet Karmiani.

SJSU Student ID: 015363530

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
* Iterator Pattern - CLass FileRepository, Class Container, Class Iterator, Class OrderController
* Chain Of Responsibility Pattern - Class CategoryLimitExceededValidation, Class ItemLimitExceededValidation, Class Validation, Class ValidationRequest, Class OrderController
* Singleton Design Pattern - Class StockDatabase


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

