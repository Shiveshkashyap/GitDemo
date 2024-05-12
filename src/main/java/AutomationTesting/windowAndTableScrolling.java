package AutomationTesting;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.devtools.v119.css.model.Value;

import java.util.List;

;

public class windowAndTableScrolling {
    public static void main(String[]args) throws InterruptedException {
        System.setProperty("Web driver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().fullscreen();
//        For scrolling we use JavaScript, below example:
         JavascriptExecutor js =(JavascriptExecutor) driver;
         js.executeScript("window.scrollBy(0,600)");
         Thread.sleep(3000);
         js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

      List<WebElement> sums = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
      int sum = 0;
      for(int i =0 ; i<sums.size();i++){
         Integer Amount= Integer.parseInt(sums.get(i).getText());
         sum = sum+Amount;
      }
        System.out.println(sum);
//        System.out.println(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText());
        Integer totalValue= Integer.parseInt(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim());

         driver.quit();
    }
}
