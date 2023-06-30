package com.cydeo.tests.day08_properties_config_reader;

import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebOrderUtils;
import com.github.dockerjava.api.model.CpuStatsConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_WebTable_Order_Verify {
    WebDriver driver;
    @BeforeMethod
    public void Setup(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //1. Go to: https://practice.cydeo.com/web-tables
        driver.get("https://practice.cydeo.com/web-tables");



    }
    @Test
    public void order_verify_name_test(){
        //TC #1: Web table practice
//2. Verify Bob’s name is listed as expected.
        //below is locating the cell where bob is
        WebElement bobsCell = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']"));
        System.out.println("bobsCell.getText() = " + bobsCell.getText());
//Expected: “Bob Martin”
        String expectedName = "Bob Martin";
        String actualName = bobsCell.getText();

        Assert.assertEquals(expectedName, actualName, "Names are not matching");
//3. Verify Bob Martin’s order date is as expected

        WebElement OrderDate = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='12/31/2021']"));
        String expectedDate = "12/31/2021";
        String actualDate = OrderDate.getText();

        Assert.assertEquals(expectedDate, actualDate, "They are not equal");
//Expected: 12/31/2021
    }

    @Test
    public void test2_use_order_verify_method(){
        //call utility method
      String alexandraGray =  WebOrderUtils.returnOrderDate(driver, "Alexandra Gray");
        System.out.println("alexandraGray = " + alexandraGray);

        String BartFisher = WebOrderUtils.returnOrderDate(driver, "Bart Fisher");
        System.out.println("BartFisher = " + BartFisher);
    }

    @Test
    public void test3(){
        WebOrderUtils.orderVerify(driver, "Bob Martin", "12/31/2021");
    }


}
