package com.cydeo.tests.day11_pom_explicit_wait;

import com.cydeo.utilities.BrowsersUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class T1_JSExecutor_Scroll {
    @AfterMethod
    public void TearDown(){
        Driver.closeDriver();
    }
    @Test
    public void Scroll_UsingJavaScriptExecutor(){
        //TC #1: Scroll using JavascriptExecutor
        //1- Open a Chrome browser
        //2- Go to: https://practice.cydeo.com/large
        Driver.getDriver().get("https://practice.cydeo.com/large");
        //Locating the link to be use later
        WebElement CydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));
        WebElement HomeLink = Driver.getDriver().findElement(By.linkText("Home"));

        //Create JavaScriptExecutor to be used later

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        //3- Scroll down to “Cydeo” link
        BrowsersUtils.sleep(2);
        js.executeScript("arguments[0].scrollIntoView(true)", CydeoLink, HomeLink);
        //4- Scroll up to “Home” link

        BrowsersUtils.sleep(2);
        js.executeScript("arguments[1].scrollIntoView(true)", CydeoLink, HomeLink);

        //5- Use below provided JS method only
        //JavaScript method to use : arguments[0].scrollIntoView(true)
        //Note: You need to locate the links as web elements and pass them as
        //arguments into executeScript() method
    }
}
