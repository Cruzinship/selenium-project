package com.cydeo.tests.day02_locators_getTest_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_CydeoVerifications {
    public static void main(String[] args) {

        //1- Setting up the web driver manager
        WebDriverManager.chromedriver().setup();
        //2- Create the instance of Chrome browser driver
       WebDriver driver = new ChromeDriver();
        //3 - Test if driver and browser are working as expected

        driver.navigate().to("https://practice.cydeo.com");

        driver.manage().window().maximize();

        String expectedInURL = "cydeo";
        String actualURl = driver.getCurrentUrl();

        if (actualURl.contains(expectedInURL)){
            System.out.println("URL verification PASSED!!");
        }else{
            System.out.println("URL verification FAILED!!!");
        }
String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Title verification PASSED!!");
        }else{
            System.out.println("Title verification FAILED!!");
        }
        driver.close();
    }
}
/*
TC #1: Cydeo practice tool verifications
1. Open Chrome browser
2. Go to https://practice.cydeo.com
3. Verify URL contains
Expected: cydeo
 4. Verify title:
Expected: Practice

 */