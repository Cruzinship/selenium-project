package com.cydeo.tests.day11_pom_explicit_wait;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T7_T8_T9_POM_Practices {
LibraryLoginPage LoginPage;

    @BeforeMethod
    public void setupMethod(){
        //1- Open a Chrome browser
        //2- Go to: https://library1.cydeo.com
        Driver.getDriver().get("https://library1.cydeo.com");
        LoginPage = new LibraryLoginPage();
    }
/*
    @AfterMethod
    public void TearDownMethod(){
        Driver.closeDriver();
    }

 */

    @Test
    public void T7_field_require_error_message_test(){
        //TC #7: Required field error message test


        //4- Click to “Sign in” button
        LoginPage.signInButton.click();

        //5- Verify expected error is displayed:
        Assert.assertTrue(LoginPage.fieldRequiredErrorMessage.isDisplayed());
        //Expected: This field is required.
        //NOTE: FOLLOW POM DESIGN PATTERN
    }
    @Test
    public void T8_Invalid_email_format_error_message_txt(){
        //TC #8: Invalid email format error message test
        //3- Enter invalid email format
LoginPage.emailInput.sendKeys("username");
        //4- Verify expected error is displayed:
        Assert.assertTrue(LoginPage.enterValidEmailErrorMessage.isDisplayed());
        //Expected: Please enter a valid email address.
        //
        //NOTE: FOLLOW POM DESIGN PATTERN
    }
    @Test
    public void t9_wrong_email_or_password_error_message(){
        //TC #9: Library negative login

        //3- Enter incorrect username or incorrect password
        LoginPage.emailInput.sendKeys("username@wrongsomething.com");
        LoginPage.password.sendKeys("somethingIncorrect");
        LoginPage.signInButton.click();

        //4- Verify expected error is displayed:
        //Expected: Sorry, Wrong Email or Password
        Assert.assertTrue(LoginPage.wrongEmailOrPasswordErrorMessage.isDisplayed());
    }
}
