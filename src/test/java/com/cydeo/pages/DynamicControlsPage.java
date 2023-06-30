package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlsPage {
    //#1- Initialize the driver and object

    public DynamicControlsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Instead of using findElement wew will now use FindBy notation
    @FindBy(xpath = "//button[text()='Remove']")
    public WebElement RemoveButton;

    @FindBy(xpath = "//div[@id='loading']")
    public WebElement loadingBar;

    //@FindBy(xpath = "//input[@type='checkbox']")
    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement checkBox;

    @FindBy(xpath = "//button[.='Enable']")
    public WebElement enableButton;

    @FindBy(xpath = "(//div[@id='loading'])[2]")
    public WebElement loadingBar2;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement inputBox;
    @FindBy(id = "message")
    public WebElement message;
}
