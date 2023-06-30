package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.lang.model.element.Element;

public class T1_Locators_getText {

    public static void main(String[] args) {

       // WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();
        //1- Open a Chrome browser

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
        //2- Go to: https://login1.nextbasecrm.com
driver.navigate().to("https://login1.nextbasecrm.com");
       // 3- Enter incorrect username: “incorrect”
        WebElement Username = driver.findElement(By.name("USER_LOGIN"));
        Username.sendKeys("incorrect");
        //4- Enter incorrect password: “incorrect”
        WebElement PassWord = driver.findElement(By.name("USER_PASSWORD"));
        PassWord.sendKeys("incorrect");
        //5- Click to Login button.
        WebElement Login = driver.findElement(By.className("login-btn"));
        Login.click();
        //6- Verify error message text is as expected:
        //Expected: Incorrect login or password
String expectedErrorText = "Incorrect login or password";
String actualErrorText = driver.findElement(By.className("errortext")).getText();

if(actualErrorText.equals(expectedErrorText)){
    System.out.println("Error text verification PASSED!");
}else{
    System.out.println("Error text verification FAILED!");
}

    }
}
/*
TC #1: NextBaseCRM, locators and getText() practice
1- Open a Chrome browser
2- Go to: https://login1.nextbasecrm.com/
3- Enter incorrect username: “incorrect”
4- Enter incorrect password: “incorrect”
5- Click to Login button.
6- Verify error message text is as expected:
Expected: Incorrect login or password

PS: Inspect and decide which locator you should be using to locate web
elements.
 */