package AutomationTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class limitingWebDriverScope {
    public static void main(String[]args) throws InterruptedException{
        System.setProperty("Web driver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");
        System.out.println(driver.findElement(By.tagName("a")).getSize());
        WebElement footerDriver= driver.findElement(By.id("gf-BIG"));
        System.out.println(footerDriver.findElement(By.tagName("a")).getSize());
        WebElement columnDriver = driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(columnDriver.findElement(By.tagName("a")).getSize());
//        String column = String.valueOf(columnDriver.findElement(By.tagName("a")).getSize());

        String clickonlinktab = Keys.chord(Keys.CONTROL,Keys.ENTER);// this keyword help to open link in new tab

       columnDriver.findElement(By.linkText("REST API")).sendKeys(clickonlinktab);
       columnDriver.findElement(By.linkText("SoapUI")).sendKeys(clickonlinktab);
        columnDriver.findElement(By.linkText("Appium")).sendKeys(clickonlinktab);
        columnDriver.findElement(By.linkText("JMeter")).sendKeys(clickonlinktab);
        Thread.sleep(5000);
        Set<String> windows =driver.getWindowHandles();
        Iterator<String> windowSwitch = windows.iterator();
//        String it = windowSwitch.next();// Parent window
        while (windowSwitch.hasNext()){

           driver.switchTo().window(windowSwitch.next()) ;
            System.out.println(driver.getTitle());


        }


        }


    }

