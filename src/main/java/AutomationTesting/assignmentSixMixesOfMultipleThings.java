package AutomationTesting;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Locale;

public class assignmentSixMixesOfMultipleThings {
    public static void main(String[]args){
        System.setProperty("Web driver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");
//        driver.findElement(By.id("checkBoxOption2")).click();// Don't use id or box to select, using Label Text
        driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]/input")).click();
        String text = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();
//        System.out.println(text);
//        System.out.println(driver.findElement(By.id("checkbox-example")).getText());
        WebElement Dropdown= driver.findElement(By.id("dropdown-class-example"));
        Select drop = new Select(Dropdown);
        drop.selectByVisibleText(text);
        driver.findElement(By.id("name")).sendKeys(text);
        driver.findElement(By.id("alertbtn")).click();
        String PopUp =driver.switchTo().alert().getText();
        if (text.contains(text)){
            System.out.println("Alert successfully Validated");

        }
        else
            System.out.println("Messages not Validated");

        driver.switchTo().alert().accept();
//        driver.quit();


    }

}
