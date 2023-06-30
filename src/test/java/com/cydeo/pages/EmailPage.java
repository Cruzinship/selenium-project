package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class EmailPage {

    public void EmailPage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }
    @FindBy(xpath = "//input[@name='USER_LOGIN']")
    public WebElement LoginInput;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement PasswordInput;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement LoginButton;

    @FindBy(xpath = "//a[@title='Mail']")
    public WebElement Email;
}
