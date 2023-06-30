package com.cydeo.tests.day09_review_javaFaker_driverUtil;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T2_DriverUtil_Practice {
   // WebDriver driver;
  //  @BeforeMethod
    //public void setUpMethod(){
        //1- Open a chrome browser
    //    driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
   //     driver.manage().window().maximize();
   //     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 //   }


    @Test
    public void bing_search_test(){
        //2- Go to: https://bing.com
        //Driver.getDriver() ----> will return me the "driver"
        //instead of writing "driver" from now on, we will write Driver.getDriver();

             Driver.getDriver().get(ConfigurationReader.getProperty("bingURL"));
        //3- Write “apple” in search box
        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue") + Keys.ENTER);

        //4- Verify title:
        // Expected: apple - Search
        String actualTitle = Driver.getDriver().getTitle();
//We are just making the expectedTitle dynamic based on the text we are searching.

        String expectedTitle = ConfigurationReader.getProperty("searchValue")+" - Search";

        Assert.assertTrue(actualTitle.equals(expectedTitle));
    }

    @Test
    public void bing_search_test2(){
        //2- Go to: https://bing.com
        //Driver.getDriver() ----> will return me the "driver"
        //instead of writing "driver" from now on, we will write Driver.getDriver();

        Driver.getDriver().get(ConfigurationReader.getProperty("bingURL"));
        //3- Write “apple” in search box
        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue") + Keys.ENTER);

        //4- Verify title:
        // Expected: apple - Search
        String actualTitle = Driver.getDriver().getTitle();
//We are just making the expectedTitle dynamic based on the text we are searching.

        String expectedTitle = ConfigurationReader.getProperty("searchValue")+" - Search";

        Assert.assertTrue(actualTitle.equals(expectedTitle));
    }

    @AfterMethod
    public void tearDownMethod(){
        Driver.closeDriver();
    }

    //3- Write “apple” in search box
    //Use `configuration.properties` for the following:
    //1. The browser type
    //2. The URL
    //3. The search keyword
    //4. Make title verification dynamic. If search value changes, title
    //assertion should not fail.
}
