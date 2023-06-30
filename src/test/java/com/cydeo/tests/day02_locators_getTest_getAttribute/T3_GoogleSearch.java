package com.cydeo.tests.day02_locators_getTest_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearch {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        //1- Open a Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2- Go to: https://google.com
        driver.navigate().to("https://google.com");
        //3- Write “apple” in search box
        WebElement googleSearchBox = driver.findElement(By.name("q"));
        googleSearchBox.sendKeys("Apple");
        //4- Press ENTER to search
googleSearchBox.sendKeys(Keys.ENTER);
        //5- Verify title:
        //Expected: Title should start with “apple” word
String expectedTitle = "Apple";
String actualTitle = driver.getTitle();
if (actualTitle.contains(expectedTitle)){
    System.out.println("Title Verification PASSED!");
}else{
    System.out.println("Title Verification Failed!");
}
    }
}
/*
TC#3: Google search
1- Open a Chrome browser
2- Go to: https://google.com
3- Write “apple” in search box
4- Press ENTER to search
5- Verify title:
Expected: Title should start with “apple” word
 */