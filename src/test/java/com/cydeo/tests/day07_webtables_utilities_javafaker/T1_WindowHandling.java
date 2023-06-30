package com.cydeo.tests.day07_webtables_utilities_javafaker;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.time.Duration;
import java.util.Set;

public class T1_WindowHandling {
    WebDriver driver;
    @BeforeMethod
    public void Setup(){
        //1. Create new test and make set ups
        //2. Go to : https://www.amazon.com
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com");
    }
    /*
    @AfterMethod
    public void TearDown(){
        driver.quit();
    }

     */
    @Test
    public void window_handling_test(){
        //3. Copy paste the lines from below into your class
        //Lines to be pasted:
        //((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        //((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        //((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
        //4. Create a logic to switch to the tab where Etsy.com is open
       Set<String> allWindowsHandles = driver.getWindowHandles();

       for (String each : allWindowsHandles) {
           driver.switchTo().window(each);
           System.out.println("Current URl: " + driver.getCurrentUrl());
           if (driver.getCurrentUrl().contains("etsy")) {
               break;
           }
       }
        //5. Assert: Title contains “Etsy”
String actualTitle = driver.getTitle();
       String expectedInTitle = "Etsy";
        Assert.assertTrue(actualTitle.contains(expectedInTitle));

        //These lines will simply open new tabs using something called JavascriptExecutor
        //and get those pages. We will learn JavascriptExecutor later as well.
    }

}
