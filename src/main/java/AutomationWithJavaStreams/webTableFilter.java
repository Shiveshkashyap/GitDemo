package AutomationWithJavaStreams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class webTableFilter {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        String veggieFilterName = ("Rice");
        driver.findElement(By.id("search-field")).sendKeys(veggieFilterName);
/*
     String veggieName=   driver.findElement(By.xpath("//tr/td[1]")).getText();

        Assert.assertTrue(veggieFilterName.equals(veggieName));
       System.out.println(veggieName); */


//        We have to write generic code , so if brown rice white rice all should be their then it will filter out our value correctly.
//        For that we have to store all the coloumn value in List.
//        Using Java Streams below we can handle.

        List<WebElement> vegetableName = driver.findElements(By.xpath("//tr/td[1]"));

      List<WebElement> filteredList=  vegetableName.stream().filter(vegetableNames->vegetableNames.getText().contains("Rice"))
              .collect(Collectors.toList());

      Assert.assertEquals(vegetableName.size(),filteredList.size());



    }



}
