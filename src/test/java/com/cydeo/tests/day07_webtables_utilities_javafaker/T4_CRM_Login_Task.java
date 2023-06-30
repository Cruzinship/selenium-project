package com.cydeo.tests.day07_webtables_utilities_javafaker;

import com.cydeo.utilities.BrowsersUtils;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_CRM_Login_Task {

    WebDriver driver;
    @BeforeMethod
    public void Setup(){
        //TC #4: Login scenario
        //1. Create new test and make setups
        //2. Go to: http://login1.nextbasecrm.com/
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://login1.nextbasecrm.com/");

    }
    @Test
    public void test1_crm_login() {
        //3. Enter valid username
        WebElement username = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        username.sendKeys("helpdesk1@cydeo.com");
        //4. Enter valid password
        WebElement password = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys("UserUser");
        //5. Click to `LogIn` button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();
        BrowsersUtils.sleep(3);
        BrowsersUtils.verifyTitle(driver, "(2) Portal");


    }
    @Test
    public void test2_crm_login(){
        CRM_Utilities.login_crm(driver);
//6. Verify title is as expected:
        //Expected: Portal
        //We are waiting 3 secs for title to be loaded to "(2) Portal"
        BrowsersUtils.sleep(3);
BrowsersUtils.verifyTitle(driver, "(2) Portal");
    }

    @Test
    public void test3_crm_login() {
        //Logging in using the utility method we created in CRM_Utilities class
        //CRM_Utilities.login_crm(driver, "helpdesk1@cydeo.com", "UserUser");
        CRM_Utilities.login_crm(driver, "helpdesk2@cydeo.com", "UserUser");
        //6. Verify title is as expected:
        //Expected: Portal
        //We are waiting 3 secs for title to be loaded to "(2) Portal"
        BrowsersUtils.sleep(3);
BrowsersUtils.verifyTitle(driver, "(4) Portal" );

    }
}
