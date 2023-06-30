package com.cydeo.tests.day08_properties_config_reader;

import com.cydeo.utilities.BrowsersUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Properties;

public class T4_use_config_reader {
    WebDriver driver;
    @BeforeMethod
    public void SetupMethod(){
        //TC #4: Google search
        //1- Open a chrome browser
        //2- Go to: https://google.com
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //1. Go to: https://google.com
        driver.get(ConfigurationReader.getProperty("googleURL"));
    }

    @Test
    public void googleSearchTest() {
//3- Write “apple” in search box
        WebElement searchBar = driver.findElement(By.xpath("//input[@class='gLFyf']"));
searchBar.sendKeys(ConfigurationReader.getProperty("searchValue")+ Keys.ENTER);
//searchBar.submit();
        //4- Verify title:
        //Expected: apple - Google Search
        //
        String expectedTitle = ConfigurationReader.getProperty("searchValue") + "- Google Search";
        BrowsersUtils.sleep(2);
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle, actualTitle, "These titles arent equal");

        //Use `configuration.properties` for the following:
        //1. The browser type
        //2. The URL
        //3. The search keyword
        //4. Make title verification dynamic. If search value changes, title
        //assertion should not fail.
    }
}
