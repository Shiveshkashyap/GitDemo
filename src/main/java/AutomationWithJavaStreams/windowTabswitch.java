package AutomationWithJavaStreams;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class windowTabswitch {

    public static void main(String[] args) throws InterruptedException, IOException {

        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/angularpractice/");

//        Switching Window
        driver.switchTo().newWindow(WindowType.WINDOW);
        Set <String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        driver.get("https://www.rahulshettyacademy.com/");
//      String courseDesc= driver.findElements(By.cssSelector("#courses-block > div:nth-child(3) > div > div.lower-content > div.upper-box > a")).get(1).getText();
//         String description=   desc.getText();

       String quoteOwner = driver.findElement(By.xpath("//a[contains(text(),'All-Access Membership-Complete Access to 25+ Cours')]")).getText();

         driver.switchTo().window(parentWindow);
         driver.findElement(By.cssSelector("[name='name']")).sendKeys(quoteOwner);
         Thread.sleep(2000);

//         Screenshot of Webelement.

        WebElement textBox= driver.findElement(By.cssSelector("[name='name']"));
        textBox.getText();
       File file= textBox.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("logo.png"));
// Get Height and width of an webelement
        System.out.println(textBox.getRect().getDimension().getHeight());
        System.out.println(textBox.getRect().getDimension().getHeight());


    }
}
