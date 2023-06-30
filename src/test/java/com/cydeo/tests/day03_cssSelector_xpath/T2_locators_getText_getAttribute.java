package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_locators_getText_getAttribute {
    public static void main(String[] args) {
        //TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        //2- Go to: https://login1.nextbasecrm.com/
        driver.navigate().to("https://login1.nextbasecrm.com/");
        //3- Verify “remember me” label text is as expected:
        //Expected: Remember me on this computer
String expectedLabelText = "Remember me on this computer";
String actualLabelText = driver.findElement(By.className("login-item-checkbox-label")).getText();

if (actualLabelText.equals(expectedLabelText)){
    System.out.println("Label text verification PASSED");
}else{
    System.out.println("Label text verification FAILED");
}
        //4- Verify “forgot password” link text is as expected:
        //Expected: Forgot your password?

        String expectedForgotPassword = "FORGOT YOUR PASSWORD?";

        WebElement ForgotPasswordLink = driver.findElement(By.className("login-link-forgot-pass"));
String actualForgotPasswordText = ForgotPasswordLink.getText();

        if (actualForgotPasswordText.equals(expectedForgotPassword)){

            System.out.println("FPT verification PASSED");
        }else{
            System.out.println("FPT verification FAILED");
        }
        //5- Verify “forgot password” href attribute’s value contains expected:
        //Expected: forgot_password=yes
String expectedInHref = "forgot_password=yes";
        String actualHrefValue = ForgotPasswordLink.getAttribute("href");

        if (actualHrefValue.contains(expectedInHref)){
            System.out.println("Href attribute value is as EXPECTED PASS");
        }else{
            System.out.println("Href attribute value is as EXPECTED FAIL");
        }
        //PS: Inspect and decide which locator you should be using to locate web
        //elements.


    }
}
