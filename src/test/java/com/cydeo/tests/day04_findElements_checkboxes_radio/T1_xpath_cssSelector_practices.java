package com.cydeo.tests.day04_findElements_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_xpath_cssSelector_practices {
    public static void main(String[] args) throws InterruptedException {

        //TC #1 XPATH and cssSelector Practices
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");
        //3. Locate all the WebElements on the page using XPATH and/ or CSS locator only (total of 6)
        //a. "Home" link
        //Locate "Home" Link, using CssSelector, syntax #1 class attribute value
        //tagName[attribute='value']
        WebElement HomeLink_ex1 = driver.findElement(By.cssSelector("a[class='nav-link']"));

        //Locate "Home" Link, using CssSelector, syntax #1 class_attributeValue
        WebElement HomeLink_ex2 = driver.findElement(By.cssSelector("a.nav-link"));

        //Locate "Home" Link, using CssSelector, syntax #1 href attribute value using
        WebElement HomeLink_ex3 = driver.findElement(By.cssSelector("a[href='/']"));

        //b. "Forgot password" header
        //locate header, using xPath, using text of h2
        WebElement Forgot_Password_ex1 = driver.findElement(By.xpath("//h2[.='Forgot Password']"));

        //Locate header, using cssSelector, using syntax #1 locate parent element and move down to h2
        WebElement Forgot_Password_ex2 = driver.findElement(By.cssSelector("div[class='example'] > h2"));
        //Locate header, using cssSelector, using syntax #2 locate parent element and move down to h2
        WebElement Forgot_Password_x3 = driver.findElement(By.cssSelector("div.example > h2"));

        //c. "Email" text
        //Locate Email using XPath

        WebElement emailLabel_ex1 = driver.findElement(By.xpath("//label[@for='email']"));
        WebElement emailLabel_ex2 = driver.findElement(By.xpath("//label[.='E-mail']"));

        //d. E-mail input box
        //Locate EmailBox using XPath

        WebElement Email_input_ex1 = driver.findElement(By.xpath("//input[@name='email']"));

        //Locate EmailBox using XPath with contains method
        //tagName[contains(@attribute, ' value')]

        WebElement Email_input_ex2 = driver.findElement(By.xpath("//input[contains(@pattern, 'a-z')]"));

        //e. "Retrieve password" button
        //Locate using xpath

        WebElement R_Password = driver.findElement(By.xpath("//input[@type='text']"));

        //f. "Powered by Cydeo" text
        WebElement poweredByCydeoText = driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        //4. Verify all web elements are displayed

        System.out.println("HomeLink_ex1.isDisplayed() = " + HomeLink_ex1.isDisplayed());
        System.out.println("Forgot_Password_ex1.isDisplayed() = " + Forgot_Password_ex1.isDisplayed());
        System.out.println("emailLabel_ex1.isDisplayed() = " + emailLabel_ex1.isDisplayed());
        System.out.println("Email_input_ex1.isDisplayed() = " + Email_input_ex1.isDisplayed());
        System.out.println("R_Password.isDisplayed() = " + R_Password.isDisplayed());
        System.out.println("poweredByCydeoText.isDisplayed() = " + poweredByCydeoText.isDisplayed());

        Thread.sleep(5000);
        driver.close();
    }
}
