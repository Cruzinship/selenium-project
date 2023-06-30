package com.cydeo.tests.day05_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.lang.model.element.Element;
import java.time.Duration;

public class T5_dropdown_intro {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //TC#5: Verifying “Simple dropdown” and “State selection” dropdown
        //default values
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/dropdown");
    }

     @AfterMethod
     public void tearDownMethod(){
         driver.quit();
     }
    //3. Verify “Simple dropdown” default selected value is correct
    //Expected: “Please select an option”
    @Test
    public void simpleDropDownTest() {
        WebElement SimpleDropDown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(SimpleDropDown);
        String ExpectedDefaultValue = "Please select an option";
        String ActualDefaultValue = select.getFirstSelectedOption().getText();

        Assert.assertEquals(ActualDefaultValue, ExpectedDefaultValue);
        Assert.assertTrue(ActualDefaultValue.equals(ExpectedDefaultValue));

        Select stateDropDown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
String expectedDefaultStateValue = "Select a State";
String actualDefaultStateValue = stateDropDown.getFirstSelectedOption().getText();

Assert.assertEquals(actualDefaultStateValue, expectedDefaultStateValue);
        //4. Verify “State selection” default selected value is correct
        //Expected: “Select a State”
    }
}
