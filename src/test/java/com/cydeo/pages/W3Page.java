package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class W3Page {
    //#1- Initialize the driver and object
    public W3Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
// Instead of using findElement wew will now use FindBy notation
    @FindBy(id = "demo")
    public WebElement paragraph;
}
