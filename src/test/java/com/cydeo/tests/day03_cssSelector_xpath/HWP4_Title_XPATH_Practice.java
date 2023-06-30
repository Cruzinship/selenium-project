package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HWP4_Title_XPATH_Practice {
    public static void main(String[] args) throws InterruptedException {

        //HWP #4: Practice Cydeo – xpath locator practice
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //2- Go to: https://practice.cydeo.com/inputs
driver.navigate().to("https://practice.cydeo.com/inputs");
        //3- Click to “Home” link
        //Locating with xpath
       // WebElement homeLink = driver.findElement(By.xpath("//a[@class='nav-link']"));
        WebElement homeLink = driver.findElement(By.xpath("//a[text='Home']"));
        //click to the link
        Thread.sleep(1000);
        homeLink.click();

        //4- Verify title is as expected:
        //Expected: Practice
        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!");
        }
        //PS: Locate “Home” link using “xpath” locator
    }
}