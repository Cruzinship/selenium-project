package com.cydeo.tests.review;

import com.cydeo.pages.W3Page;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_DoubleClick_Practice {


    @Test
    public void ti_doubled_click_test(){
        //TC #1: Double Click Test
        //1. Go to
        //https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        //2. Switch to iframe.
        Driver.getDriver().switchTo().frame("iframeResult");
        //3. DoubleClick on the text “Double-click me to change my text color.”
        //Using W3page object to reach the 'paragraph' web element
        W3Page w3Page = new W3Page();
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(w3Page.paragraph).perform();
        //4. Assert: Text’s “style” attribute value contains “red”.
        //NOTE: FOLLOW POM
        String actualStyleAttributeValue = w3Page.paragraph.getAttribute("style");
        String expectedInAttributeValue = "red";

        Assert.assertTrue(actualStyleAttributeValue.contains(expectedInAttributeValue));
    }
}
