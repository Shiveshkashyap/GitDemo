package AutomationTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class SwitchBtwnWindowAssigment {

    public static void main(String[]args) throws InterruptedException {
        System.setProperty("Web driver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Multiple Windows")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Click Here")).click();
        Set<String> windows =driver.getWindowHandles();
        Iterator<String> it =windows.iterator();
        String parentID = it.next();
        String childID = it.next();
        Thread.sleep(3000);
        driver.switchTo().window(childID);
        System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
        driver.switchTo().window(parentID);
        System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
    }
}
