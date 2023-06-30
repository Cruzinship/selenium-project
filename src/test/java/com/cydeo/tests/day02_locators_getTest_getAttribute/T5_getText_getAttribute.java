package com.cydeo.tests.day02_locators_getTest_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Text;

public class T5_getText_getAttribute {
    public static void main(String[] args) {
        //1- Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2- Go to: https://practice.cydeo.com/registration_form
        driver.navigate().to("https://practice.cydeo.com/registration_form");
        //3- Verify header text is as expected:
        WebElement header = driver.findElement(By.tagName("h2"));

        String expectedHeaderText = "Registration form";
        String actualHeaderText = header.getText();// --> this will return me the text of the header

        if (actualHeaderText.equals(expectedHeaderText)){
            System.out.println("Header text verification PASSED!");
        }else{
            System.out.println("Header text verification FAILED!");
        }
        //4- Locate “First name” input box
        WebElement firstNameInput = driver.findElement(By.className("form-control"));

       // 5- Verify placeholder attribute’s value is as expected:
       // Expected: first name
        String expectedPlaceHolder = "first name";
        String actualPlaceHolder = firstNameInput.getAttribute("placeholder");

        System.out.println("actualPlaceHolder = " + actualPlaceHolder);

        if (actualPlaceHolder.equals(expectedPlaceHolder)){
            System.out.println("Placeholder attribute verification PASSED!");
        }else{
            System.out.println("Placeholder attribute verification FAILED!");
        }
    }
}

/*
TC #5: getText() and getAttribute() method practice
1- Open a Chrome browser
2- Go to: https://practice.cydeo.com/registration_form
3- Verify header text is as expected:
Expected: Registration form
4- Locate “First name” input box
5- Verify placeholder attribute’s value is as expected:
Expected: first name
 */