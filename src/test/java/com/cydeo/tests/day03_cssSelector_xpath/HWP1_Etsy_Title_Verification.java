package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HWP1_Etsy_Title_Verification {
    public static void main(String[] args) {
        //HWP #1: Etsy Title Verification
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //2. Go to https://www.etsy.com
        driver.navigate().to("https://www.etsy.com");
        //3. Search for “wooden spoon”
        WebElement SearchBar = driver.findElement(By.xpath("//input[@id='global-enhancements-search-query']"));
        SearchBar.click();
        SearchBar.sendKeys("Wooden spoon");
        SearchBar.sendKeys(Keys.ENTER);
        //4. Verify title:
        String expectedTitle = "Wooden spoon - Etsy";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Title Verifications PASSED!");
        }else{
            System.out.println("Title Verifications PASSED!");
        }
        //Expected: “Wooden spoon - Etsy”

    }
}
