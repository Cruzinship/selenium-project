package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_xpath {
    public static void main(String[] args) {
        //TC #3: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //2- Go to: https://login1.nextbasecrm.com/
        driver.navigate().to("https://login1.nextbasecrm.com/");
        //3- Verify “Log in” button text is as expected:
        //Expected: Log In
        String expectedLoginText = "Log In";

        //tagName[@attributes='value']
        //Locating loginButton using class attributes value
        WebElement loginButton = driver.findElement(By.xpath("//input[@type ='submit']"));


        //tagName[attribute='value']

        //Locating loginButton using cssSelector
      //  WebElement loginButton = driver.findElement(By.cssSelector("input[type='submit']"));
        String actualLoginText= loginButton.getAttribute("value");

        if (loginButton.equals(expectedLoginText)){
            System.out.println("Log In button text verification PASSED!");
        }else{
            System.out.println("Log In button text verification FAILED!");
        }


        //PS: Inspect and decide which locator you should be using to locate web
        //elements.
        //PS2: Pay attention to where to get the text of this button from
    }
}
