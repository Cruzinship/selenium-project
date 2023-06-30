package com.cydeo.tests.day02_locators_getTest_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T4_Library_Verification {
    public static void main(String[] args) {
        //1. Open Chrome browser

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Go to http://library2.cybertekschool.com/login.html

        driver.navigate().to("http://library2.cybertekschool.com/login.html");

        // 3. Enter username: “incorrect@email.com”

       WebElement EmailBox = driver.findElement(By.className("form-control"));
        EmailBox.sendKeys("incorrect@email.com");

        //4. Enter password: “incorrect password”

        WebElement passwordBox = driver.findElement(By.id("inputPassword"));
        passwordBox.sendKeys("incorrect password");

        //5. Verify: visually “Sorry, Wrong Email or Password”
        WebElement SignInButton = driver.findElement(By.tagName("button"));
SignInButton.sendKeys(Keys.ENTER);


    }
}
/*
TC #4: Library verifications
        1. Open Chrome browser
        2. Go to http://library2.cybertekschool.com/login.html
        3. Enter username: “incorrect@email.com”
        4. Enter password: “incorrect password”
        5. Verify: visually “Sorry, Wrong Email or Password”
        displayed
        PS: Locate username input box using “className” locator
        Locate password input box using “id” locator
        Locate Sign in button using “tagName” locator

 */