package AutomationTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class AddingItemToCart {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Web driver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        int j=0;
       /* Declaring Variable in JAVA:
        String name = "Cucumber";---> only this step . Variable is name , storing String type.

        Declaring Array in Java for data type String*/
        String[] vegetables = {"Cucumber","Brinjal","Cauliflower","Beans","Almonds","Pista","Pumpkin"};// PROBLEM:we only write vegetables name here but
//         in site full name is like :"Brocolli - 1 Kg,Cauliflower - 1 Kg"
//        So, we have to trim this name before sending for validation in if block
        driver.get("https://rahulshettyacademy.com/seleniumPractise");
        Thread.sleep(2000);
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i = 0; i < products.size(); i++) {

           String[] name= products.get(i).getText().split("-");
           String veggiesName= name[0].trim();
//           Still there is a PROBLEM: For that we have to trim the name before sending to validation in If block.
//           change array into arraylist for easy search, it's saved the memory
//           How we validate the Cart having item of vegetables which has been stored in Array?
//            Below are the STEPS FOR CHANGING ARRAY INTO ARRAYLIST
            List itemsNeeded = Arrays.asList(vegetables);


           if(itemsNeeded.contains(veggiesName))
           {
               j++;
              /* Adding items into cart using for loop then using if statement for choosing
               correct item by name.
               In this way we have to manually enter the Veg name all the time , but what we can
               do like : Store the vegetables name in array and then pass the array in if block ,
               so expected vegetables will   add in the CART: EASIEST Way to handle the CART.*/
               driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();

               if (j==vegetables.length)
                   break;

           }
        }

//            driver.quit();


    }



}

