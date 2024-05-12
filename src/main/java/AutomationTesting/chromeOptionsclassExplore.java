package AutomationTesting;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class chromeOptionsclassExplore {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Web driver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("Enter proxy here");
        options.setCapability("proxy","proxy");
        options.setAcceptInsecureCerts(true);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());// If we can directly wants to get Title it will
// it will gives as "Privacy error" as title. No We use ChromeOptions class


//        ********Handling Proxy in Selenium*******
//        Proxy class
//        ChromeOptions options = new ChromeOptions();
//        Proxy proxy = new Proxy();
//        proxy.setHttpProxy("Enter proxy here");
//        options.setCapability("proxy","proxy");

    }
}
