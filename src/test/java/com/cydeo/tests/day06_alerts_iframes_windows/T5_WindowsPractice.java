package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T5_WindowsPractice {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //2. Go to website: https://practice.cydeo.com/iframe
        driver.get("https://practice.cydeo.com/windows");
    }

   @AfterMethod
   public void tearDownMethod(){
       driver.quit();
    }
    @Test
    public void multiple_windows_test(){
//TC #5: Window Handle practice
        //4. Assert: Title is “Windows”
String exceptedTitle = "Windows";
String actualTitle = driver.getTitle();
        Assert.assertEquals(exceptedTitle, actualTitle, "Verification failed");

        String mainHandle = driver.getWindowHandle();
        System.out.println("mainHandle = " + mainHandle);
        System.out.println("Title before clicking " + driver.getTitle());

//5. Click to: “Click Here” link
        WebElement clickHere = driver.findElement(By.linkText("Click Here"));
        clickHere.click();
        System.out.println("Title after clicking " + driver.getTitle());
//6. Switch to new Window.
        //1- windowHandle : mainHandle
        //2- windHandle : 2nd window

       for (String each : driver.getWindowHandles()){
           driver.switchTo().window(each);
           System.out.println("Current title switching windows: " + driver.getTitle());
       }
//7. Assert: Title is “New Window”
        String expectedTitleAfterClass = "New Window";
       String actualTitleAfterClass = driver.getTitle();
       Assert.assertEquals(expectedTitleAfterClass, actualTitleAfterClass, "Failed");

       // If we have to go back to the main page to continue our test case.
        //we can use mainHandle to switch back.
        driver.switchTo().window(mainHandle);
        //code

    }
}
