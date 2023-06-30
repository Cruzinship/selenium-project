package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.BrowsersUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Registration_Form {
    //TC#1: Registration form confirmation
    @Test
    public void RegistrationForm() {
        //1. Open browser
        //2. Go to website: https://practice.cydeo.com/registration_form
        Driver.getDriver().get(ConfigurationReader.getProperty("PCydeoR"));

        // 3. Enter first name
        WebElement FirstNameBox = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        FirstNameBox.sendKeys("JANE");

        //4. Enter last name
        WebElement LastNameBox = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        LastNameBox.sendKeys("DOE");

        //5. Enter username
        WebElement UserNameBox = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        UserNameBox.sendKeys("janedoe58");

        //6. Enter email address
        WebElement EmailBox = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        EmailBox.sendKeys("janedoe@example.com");

        //7. Enter password
        WebElement passwordBox = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        passwordBox.sendKeys("1234567890");

        //8. Enter phone number
        WebElement phoneNumberBox = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        phoneNumberBox.sendKeys("444-555-6666");

        //9. Select a gender from radio buttons
        WebElement genderRadioSelector = Driver.getDriver().findElement(By.xpath("//input[@value='female']"));
        genderRadioSelector.click();

        //10.Enter date of birth
        WebElement birthdayBox = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        birthdayBox.sendKeys("01/20/1980");

        //11.Select Department/Office
        //departmentDropdown.selectByVisibleText("Department of Engineering");
        Select departmentDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        departmentDropdown.selectByValue("DE");

        //12.Select Job Title
        Select jobTitle = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        jobTitle.selectByVisibleText("SDET");

        //13.Select programming language from checkboxes
        WebElement JavaCheckBox = Driver.getDriver().findElement(By.xpath("//input[@value='java']"));
        JavaCheckBox.click();

        //14.Click to sign up button
        BrowsersUtils.sleep(2);
        WebElement signUpButton = Driver.getDriver().findElement(By.xpath("//button[@id='wooden_spoon']"));
        signUpButton.click();

        //15.Verify success message “You’ve successfully completed registration.” is
        WebElement successMessage = Driver.getDriver().findElement(By.xpath("//div[@role='alert']"));
        Assert.assertTrue(successMessage.isDisplayed());
        //displayed.

        //driver.quit();
        //Driver.getDriver().quit(); --> we don't use this method anymore. Because we want to assign the value back to null
        // So if we have another test, our code can continue executing.

        Driver.closeDriver();
    }

}
