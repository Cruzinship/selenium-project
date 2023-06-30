package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HWP2_ZeroBank_XPATH_CSS {
    public static void main(String[] args) {
        //HWP #2: Zero Bank header verification
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //2. Go to http://zero.webappsecurity.com/login.html
        driver.navigate().to("http://zero.webappsecurity.com/login.html");
        //3. Verify header text
        WebElement headerText = driver.findElement(By.xpath("//h3"));
        String expectedHeader = "Log in to ZeroBank";
        String actualHeader = headerText.getText();

        if (actualHeader.equals(expectedHeader)){
            System.out.println("Header verification PASSED");
        }else{
            System.out.println("Header verification Failed");
        }
        //Expected: “Log in to ZeroBank”


    }
}
