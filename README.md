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

# Screenshots of running code

* Giving dataset file and input file 1 as inputs
  
<img width="1440" alt="Screen Shot 2021-12-05 at 8 10 07 PM" src="https://user-images.githubusercontent.com/26499781/144786601-2dd1d804-3b12-4c38-a15d-10211b4b152c.png">

* Output of input file 1

<img width="1440" alt="Screen Shot 2021-12-05 at 8 13 43 PM" src="https://user-images.githubusercontent.com/26499781/144786669-a40f9232-caac-4fac-bfa6-7e6de7b333df.png">

* Output of input file 2

<img width="1440" alt="Screen Shot 2021-12-05 at 8 14 42 PM" src="https://user-images.githubusercontent.com/26499781/144786854-3d30285a-b579-4748-9048-f3a5e254e471.png">

* Output of file 3

<img width="1440" alt="Screen Shot 2021-12-05 at 8 15 19 PM" src="https://user-images.githubusercontent.com/26499781/144786889-ec97d855-b929-4103-bed5-70e1af6cf1d0.png">

* Output of ending the program

<img width="1440" alt="Screen Shot 2021-12-05 at 8 15 57 PM" src="https://user-images.githubusercontent.com/26499781/144786923-eb668e74-2c7b-4441-9b90-3fffb5ea142b.png">

