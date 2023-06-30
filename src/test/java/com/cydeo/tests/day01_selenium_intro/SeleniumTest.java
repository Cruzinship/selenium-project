package com.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumTest {
    public static void main(String[] args) {

        //1- Setting up the web driver manager
        WebDriverManager.chromedriver().setup();

        //2- Create the instance of Chrome browser driver
        WebDriver driver = new ChromeDriver();

        //3 - Test if driver and browser are working as expected
       driver.get("http://www.google.com");

        //WebElement SearchBar = driver.findElement(By.xpath("//textarea[@title='Search']"));
        //SearchBar.sendKeys("Kayla is blacker than black");
        //SearchBar.sendKeys(Keys.ENTER);


    }
}
