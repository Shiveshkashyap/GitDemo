package AutomationWithJavaStreams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static AutomationWithJavaStreams.relativeLocator.*;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class relativeLocator {

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/angularpractice/");
       WebElement editBox= driver.findElement(By.cssSelector("[name='name']"));
        System.out.println(driver.findElement(with(By.tagName("label")).above(editBox)).getText());


//        Next task to using below command we can perform.

        WebElement dateBirth = driver.findElement(By.xpath("//label[contains(text(),\"Date of Birth\")]"));
//        css selector : [for="dateofBirth"]


      driver.findElement(with(By.tagName("input")).below(dateBirth)).click();

//      Now try to do with left command

       WebElement checkbox= driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
       driver.findElement(with(By.tagName("input")).toLeftOf(checkbox)).click();

//       Next using right left command also.

       WebElement radioButton= driver.findElement(By.id("inlineRadio1"));
        System.out.println(driver.findElement(with(By.tagName("input")).toRightOf(radioButton)).getText());



    }
}
