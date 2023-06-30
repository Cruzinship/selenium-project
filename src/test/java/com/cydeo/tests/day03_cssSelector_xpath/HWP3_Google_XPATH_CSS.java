package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.lang.model.element.Element;

public class HWP3_Google_XPATH_CSS {
    public static void main(String[] args) {
//TC #3: Back and forth navigation
//1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
//2- Go to: https://google.com
        driver.navigate().to("https://google.com");
//3- Click to Gmail from top right.

        //tagName[text()='textValue']
       // WebElement Gmail = driver.findElement(By.xpath("//a[@href='https://mail.google.com/mail/&ogbl']"));

        //Using the text of the web element with XPATH locator
        //tagName[text()='textValue']--> //tagName[.='textValue']
        //WebElement Gmail = driver.findElement(By.xpath("//a[text()='Gmail']"));

        //Using the text of the web element with "CssSelector"
        // --> tagName[attribute='value']
        WebElement Gmail = driver.findElement(By.cssSelector("a[href='https://mail.google.com/mail/&ogbl']"));


        //Click to the gmail link

        Gmail.click();
//4- Verify title contains:
        //Expected: Gmail

        String expectedGmailTitle = "Gmail";
        String actualGmailTitle = driver.getTitle();

if (actualGmailTitle.contains(expectedGmailTitle)){
    System.out.println("Gmail title verification PASSED!");
}else{
    System.out.println("Gmail title verification PASSED!");
}
//5- Go back to Google by using the .back();
        driver.navigate().back();
//6- Verify title equals:
        driver.getTitle();
        String expectedTitle2 = "Google";
        String actualTitle3 = driver.getTitle();

        if (expectedTitle2.contains(actualTitle3)){
            System.out.println("Title Verification PASSED!");
        }else{
            System.out.println("Title Verification FAILED!");
        }
//Expected: Google
    }
}
