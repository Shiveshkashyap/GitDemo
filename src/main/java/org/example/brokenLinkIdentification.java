package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static javax.swing.text.html.CSS.getAttribute;

public class brokenLinkIdentification {
    public static void main(String[]args) throws MalformedURLException, IOException {

        System.setProperty("Web Driver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");
//        ********* CSS selector for getting link. Customized css : 'a[href*="soapui"]'
        List<WebElement> allURL =driver.findElements(By.cssSelector("li[class='gf-li'] a"));
//        below is the enhanced For-Loop, in which single loop iterate through each link
        SoftAssert a = new SoftAssert();// creating , testng assert class.
        for (WebElement link : allURL){
           String url= link.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
           int responseCode= conn.getResponseCode();
//           We can omit this "if" block because once it found the broken url, it stops executing the script.
//            so we need to do SOFTassert , so it will resume the execution without failing.
        /*   if(responseCode>400){
               Assert.assertTrue(false);


           }*/
            a.assertTrue(responseCode>400,"The link in the Text"+link.getText()+"is broken with code"+responseCode );
        }



      /*  String soapuiUrl = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
//      there is class in Java : HttpURLConnection, using this link we will be able to check it  , we have to created a obj of that class to get all the method of that connection class
        HttpURLConnection conn = (HttpURLConnection) new URL(soapuiUrl).openConnection();// 1st within Bracket is typcasting , because we are using String as a url
        conn.setRequestMethod("HEAD");
        conn.connect();
        int response = conn.getResponseCode();
        System.out.println(response);*/

//        Now we will write some code to iterate through all the link in footer and check  whether it is workable or not using assertion.
//    a.assertAll();
    }

}
