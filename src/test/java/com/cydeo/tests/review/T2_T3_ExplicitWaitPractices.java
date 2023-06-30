package com.cydeo.tests.review;

import com.cydeo.pages.DynamicControlsPage;
import com.cydeo.utilities.BrowsersUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.time.Duration;

public class T2_T3_ExplicitWaitPractices {
    DynamicControlsPage dynamicControlsPage;

    @BeforeMethod
    public void SetupMethod() {
        //1- Open a Chrome browser
        //2- Go to: https://practice.cydeo.com/dynamic_controls
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");
        dynamicControlsPage = new DynamicControlsPage();
    }

    @Test
    public void Explicit_wait_practice1() {
        //TC #2: Explicit wait practice
        //3- Click to “Remove” button
        dynamicControlsPage.RemoveButton.click();
        //4- Wait until “loading bar disappears”
        //4- Wait until “loading bar disappears”
        //Create the object of 'WebDriverWait' class, and set up the constructor args
        //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //use the 'wait' object with the proper syntax to create explicit wait conditions.
        //wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingBar));

        //Using the custom utility method 'waitForInvisibilityOf' to wait loadingBar disappears
        //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //use the 'wait' object with the proper syntax to create explicit wait conditions.
        //wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingBar));
        //Using the custom utility method 'waitForInvisibilityOf' to wait for loading bar to disappear
        BrowsersUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);
        //5- Verify:
        //a. Checkbox is not displayed
        // dynamicControlsPage.checkbox.isDisplayed() --> if displayed, returns true;
        // dynamicControlsPage.checkbox.isDisplayed() --> if not displayed, returns false;

        //Assert.assertTrue(!dynamicControlsPage.checkbox.isDisplayed());
        try {
            //assertFalse method is expecting a "false" boolean value to PASS the test.
            Assert.assertFalse(dynamicControlsPage.checkBox.isDisplayed());
        } catch (NoSuchElementException n) {
            //n.printStackTrace();
            System.out.println("NoSuchElementException is thrown. It means that the Checkbox is not on the page");
            Assert.assertTrue(true);
        }
        //b. “It’s gone!” message is displayed.
        Assert.assertTrue(dynamicControlsPage.message.isDisplayed());
    }

    @Test
    public void t3_input_input_box_test() {
//TC #3: Explicit wait practice
        //3- Click to “Enable” button
        //Use the object to click to enable button
        dynamicControlsPage.enableButton.click();
        //4- Wait until “loading bar disappears”
BrowsersUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);
        //5- Verify:
        //a. Input box is enabled.
        Assert.assertTrue(dynamicControlsPage.inputBox.isDisplayed(),"Input box is not enabled");
        //b. “It’s enabled!” message is displayed.
        Assert.assertTrue(dynamicControlsPage.message.isDisplayed(), "Message is not enabled");

        String actualMessageText = dynamicControlsPage.message.getText();

Assert.assertTrue(dynamicControlsPage.message.getText().equals("It's enabled!"));
    }

    @AfterMethod
    public void TearDownMethod() {
        Driver.closeDriver();
    }
}
