package AutomationWithJavaStreams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class webTableSorting {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
//        Thread.sleep(5000);
        /* below are the points we have to perform
        1. click on the column
        driver.findElement(By.xpath("//tr/th[1]")).click();
        2.capture all the webelement text into a list
     List <WebElement> tableList = driver.findElements(By.xpath("//tr/td[1]"));
        3. sort that list
        4. print the sorted list

         */

        driver.findElement(By.xpath("//tr/th[1]")).click();
        List<WebElement> tableList = driver.findElements(By.xpath("//tr/td[1]"));

        //using streams we can get the text of all the item
        List<String> newTableList = tableList.stream().map(s -> s.getText()).collect(Collectors.toList());
//        Assert.assertTrue(tableList.equals(newTableList));

        List<String> sortedList = newTableList.stream().sorted().collect(Collectors.toList());

//        Comparing between two table list
        Assert.assertTrue(newTableList.equals(sortedList));


//        System.out.println(newTableList);
//        newTableList.stream().sorted().forEach(s -> System.out.println(s));

        /*
        how to get the price of specific veggie tables.
     scan the name of vegetables and print their price

         */

        List<String> price = tableList.stream().filter(s -> s.getText().contains("Beans")).map(s -> getVeggiePrice(s)).collect(Collectors.toList());
        price.forEach(a -> System.out.println(a));


    }

    private static String getVeggiePrice(WebElement s) {

        String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return pricevalue;
    }


}