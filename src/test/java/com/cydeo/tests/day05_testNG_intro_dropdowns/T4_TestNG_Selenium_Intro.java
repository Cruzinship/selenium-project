package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_TestNG_Selenium_Intro {
    WebDriver driver;
@BeforeMethod
public void setUpMethod(){
    //1.Open Chrome browser
    //2.Go to https://www.cydeo.com
    driver = WebDriverFactory.getDriver("chrome");
    driver.get("https://practice.cydeo.com");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
@AfterMethod
public void tearDown(){
    driver.quit();
}
    @Test
    public void test1_cydeo_title_verification(){
        //TC #4: Cydeo Title Verification

        //3.Verify title:
        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);
        //Expected: Cydeo
    }
}
