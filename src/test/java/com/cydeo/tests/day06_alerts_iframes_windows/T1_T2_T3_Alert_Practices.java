package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import com.github.dockerjava.api.model.CpuStatsConfig;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_T2_T3_Alert_Practices {
    WebDriver driver;

    @BeforeMethod
    public void Setup() {
        //1. Open browser
        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://practice.cydeo.com/javascript_alerts");

    }

    @AfterMethod
    public void tearDownMethod(){
driver.quit();
    }

    //TC #1: Information alert practice
    @Test
    public void information_alert_test1() {
        //3. Click to “Click for JS Alert” button
        WebElement informationAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        informationAlertButton.click();
        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();
        //5. Verify “You successfully clicked an alert” text is displayed.
        WebElement greenText = driver.findElement(By.xpath("//p[.='You successfully clicked an alert']"));

        Assert.assertTrue(greenText.isDisplayed(), "Result text is NOT Displayed");

        String expectedText = "You successfully clicked an alert";
        String actualText = greenText.getText();

        Assert.assertEquals(actualText, expectedText, "Result text is NOT Displayed");

    }

    @Test
    public void confirmation_alert_test2(){
        //TC #2: Confirmation alert practice
        //3. Click to “Click for JS Confirm” button
        WebElement JsConfirmButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        JsConfirmButton.click();
        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();
        //5. Verify “You clicked: Ok” text is displayed.
        WebElement MoreGreenText = driver.findElement(By.xpath("//p[.='You clicked: Ok']"));
        Assert.assertTrue(MoreGreenText.isDisplayed(), "You clicked: Ok isnt Displayed");
        String expectedText1 = "You clicked: Ok";
        String actualText1 = MoreGreenText.getText();
        Assert.assertEquals(actualText1, expectedText1, "These are not equal, therefore test failed");



    }

    @Test
    public void information_alert_test3(){
        //TC #3: Information alert practice
        //3. Click to “Click for JS Prompt” button
        WebElement JsPrompt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        JsPrompt.click();
        //4. Send “hello” text to alert
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");
        //5. Click to OK button from the alert
        alert.accept();
        //6. Verify “You entered: hello” text is displayed.
        WebElement NewText = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(NewText.isDisplayed(), "Verification failed" );
        String expectedOutput = "You entered: hello";
        String actualOutput = NewText.getText();
        Assert.assertEquals(actualOutput, expectedOutput, "Verification failed");
    }
}

