package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.BrowsersUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class T6_JavascriptExecutor_Practice {
    @Test
    public void infinite_scroll_test_using_JSExecutor() {
//TC #6: Scroll using JavascriptExecutor
//1- Open a Chrome browser
//2- Go to: https://practice.cydeo.com/infinite_scroll
        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");

        //((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0,-750)");

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        BrowsersUtils.sleep(2);

        //window.scrollBY(x,y)

        //3- Use below JavaScript method and scroll
//a. 750 pixels down 10 times.
        for (int i = 0; i < 10 ; i++) {
            BrowsersUtils.sleep(1);
            js.executeScript("window.scrollBy(0, 750)");
        }

//b. 750 pixels up 10 times
//JavaScript method to use : window.scrollBy(0,0)
        for (int i = 0; i < 10; i++) {
            BrowsersUtils.sleep(1);
            js.executeScript("window.scrollBy(0, -750)");
        }
    }
}