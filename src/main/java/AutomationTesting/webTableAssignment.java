package AutomationTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class webTableAssignment {
    public static void main(String[]args){
        System.setProperty("Web driver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");
        WebElement table= driver.findElement(By.id("product"));// create web element we need count of item this is the reason
        System.out.println(table.findElements(By.tagName("tr")).size());//size of row
        System.out.println(table.findElements(By.tagName("th")).size());
        List<WebElement> secondRowDetails = driver.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));

        System.out.println(secondRowDetails.get(0).getText());
        System.out.println(secondRowDetails.get(1).getText());
        System.out.println(secondRowDetails.get(2).getText());

    }
}
