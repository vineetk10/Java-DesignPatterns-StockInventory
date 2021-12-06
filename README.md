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
* Iterator Pattern - CLass FileRepository, Class Container, Class Iterator, Class OrderController
* Chain Of Responsibility Pattern - Class CategoryLimitExceededValidation, Class ItemLimitExceededValidation, Class Validation, Class ValidationRequest, Class OrderController
* Singleton Design Pattern - Class StockDatabase


# Class Diagram


![StockInventoryCD](https://user-images.githubusercontent.com/26499781/144785513-b5eb3103-6806-4549-a929-f58b73c5215a.png)
