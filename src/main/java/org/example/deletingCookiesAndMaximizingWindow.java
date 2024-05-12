package org.example;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class deletingCookiesAndMaximizingWindow {
    public static void main(String[]args){
        System.setProperty("Web Driver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();// Maximize the window.
        driver.manage().deleteAllCookies();// this will delete all the cookies
        driver.manage().getCookieNamed("ASDF");// It will delete the using specific name
        driver.get("http://google.com");
//******************************Taking screenshot in Selenium************************
//        We have to change the driver as Screenshot Object , with below steps.
       File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);// this will take screenshot as file .

    }
}
