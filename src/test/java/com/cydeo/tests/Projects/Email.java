package com.cydeo.tests.Projects;

import com.beust.ah.A;
import com.cydeo.pages.EmailPage;
import com.cydeo.utilities.BrowsersUtils;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.WebOrderUtils;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Email {

   @AfterMethod
    public void TearDownMethod() {
       Driver.closeDriver();
   }

    @Test
    public void EmailPage() {
        Driver.getDriver().get("https://qa.agileprocrm.com/stream/?login=yes");
        WebElement EmailInput = Driver.getDriver().findElement(By.xpath("//input[@name='USER_LOGIN']"));
        WebElement Password = Driver.getDriver().findElement(By.xpath("//input[@type='password']"));
        WebElement LoginButton = Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
        EmailInput.sendKeys("hr1@cybertekschool.com");
        Password.sendKeys("UserUser");
        LoginButton.submit();
        //Login Page done

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "(17) Portal";
       //Assert.assertTrue(actualTitle.equals(expectedTitle));
        System.out.println(actualTitle);

        WebElement MailButton = Driver.getDriver().findElement(By.xpath("//a[@title='Mail']"));
        MailButton.click();

        String actualTitle2 = Driver.getDriver().getTitle();
        String expectedTitle2 = "(17) Mailbox Integration";
        //Assert.assertTrue(actualTitle2.equals(expectedTitle2));
        System.out.println(actualTitle2);

        WebElement Text = Driver.getDriver().findElement(By.xpath("//div[.='Use and manage your mailbox in Bitrix24']"));
        WebElement Gmail = Driver.getDriver().findElement(By.xpath("(//a[@class='mail-add-item'])[1]"));
        WebElement OutLook = Driver.getDriver().findElement(By.xpath("(//a[@class='mail-add-item'])[2]"));
        WebElement iCloud = Driver.getDriver().findElement(By.xpath("(//a[@class='mail-add-item'])[3]"));
        WebElement Office365 = Driver.getDriver().findElement(By.xpath("(//a[@class='mail-add-item'])[4]"));
        WebElement Exchange = Driver.getDriver().findElement(By.xpath("(//a[@class='mail-add-item'])[5]"));
        WebElement Yahoo = Driver.getDriver().findElement(By.xpath("(//a[@class='mail-add-item'])[6]"));
        WebElement Aol = Driver.getDriver().findElement(By.xpath("(//a[@class='mail-add-item'])[7]"));
        WebElement Imap = Driver.getDriver().findElement(By.xpath("(//a[@class='mail-add-item'])[8]"));


        String expectedText = "Use and manage your mailbox in Bitrix24";
        String actualText = Text.getText();
        Assert.assertTrue(expectedText.equals(actualText));

        Assert.assertTrue(Gmail.isDisplayed());
        Assert.assertTrue(OutLook.isDisplayed());
        Assert.assertTrue(iCloud.isDisplayed());
        Assert.assertTrue(Office365.isDisplayed());
        Assert.assertTrue(Exchange.isDisplayed());
        Assert.assertTrue(Yahoo.isDisplayed());
        Assert.assertTrue(Aol.isDisplayed());
        Assert.assertTrue(Imap.isDisplayed());

        System.out.println(Gmail.getAccessibleName());
        System.out.println(OutLook.getAccessibleName());
        System.out.println(iCloud.getAccessibleName());
        System.out.println(Office365.getAccessibleName());
        System.out.println(Exchange.getAccessibleName());
        System.out.println(Yahoo.getAccessibleName());
        System.out.println(Aol.getAccessibleName());
        System.out.println(Imap.getAccessibleName()); //Ends up coming out as other

        Gmail.click();
        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//iframe[@src='/mail/config/new?id=1&IFRAME=Y&IFRAME_TYPE=SIDE_SLIDER']")));
        WebElement MailboxIntegration = Driver.getDriver().findElement(By.xpath("//div[@class='mail-msg-sidepanel-title']"));
        Assert.assertTrue(MailboxIntegration.isDisplayed());
        Driver.getDriver().switchTo().parentFrame();
        WebElement CloseButton = Driver.getDriver().findElement(By.xpath("//span[@class='side-panel-close-inner']"));
        CloseButton.click();

        OutLook.click();
        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//iframe[@src='/mail/config/new?id=2&IFRAME=Y&IFRAME_TYPE=SIDE_SLIDER']")));
        WebElement MailboxIntegration2 = Driver.getDriver().findElement(By.xpath("//div[@class='mail-msg-sidepanel-title']"));
        Assert.assertTrue(MailboxIntegration2.isDisplayed());
        Driver.getDriver().switchTo().parentFrame();
        WebElement CloseButton2 = Driver.getDriver().findElement(By.xpath("//span[@class='side-panel-close-inner']"));
        CloseButton2.click();

        iCloud.click();
        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//iframe[@src='/mail/config/new?id=3&IFRAME=Y&IFRAME_TYPE=SIDE_SLIDER']")));
        WebElement MailboxIntegration3 = Driver.getDriver().findElement(By.xpath("//div[@class='mail-msg-sidepanel-title']"));
        Assert.assertTrue(MailboxIntegration3.isDisplayed());
        Driver.getDriver().switchTo().parentFrame();
        WebElement CloseButton3 = Driver.getDriver().findElement(By.xpath("//span[@class='side-panel-close-inner']"));
        CloseButton3.click();

        Office365.click();
        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//iframe[@src='/mail/config/new?id=4&IFRAME=Y&IFRAME_TYPE=SIDE_SLIDER']")));
        WebElement MailboxIntegration4 = Driver.getDriver().findElement(By.xpath("//div[@class='mail-msg-sidepanel-title']"));
        Assert.assertTrue(MailboxIntegration4.isDisplayed());
        Driver.getDriver().switchTo().parentFrame();
        WebElement CloseButton4 = Driver.getDriver().findElement(By.xpath("//span[@class='side-panel-close-inner']"));
        CloseButton4.click();

        Exchange.click();
        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//iframe[@src='/mail/config/new?id=5&IFRAME=Y&IFRAME_TYPE=SIDE_SLIDER']")));
        WebElement MailboxIntegration5 = Driver.getDriver().findElement(By.xpath("//div[@class='mail-msg-sidepanel-title']"));
        Assert.assertTrue(MailboxIntegration5.isDisplayed());
        Driver.getDriver().switchTo().parentFrame();
        WebElement CloseButton5 = Driver.getDriver().findElement(By.xpath("//span[@class='side-panel-close-inner']"));
        CloseButton5.click();

        Yahoo.click();
        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//iframe[@src='/mail/config/new?id=6&IFRAME=Y&IFRAME_TYPE=SIDE_SLIDER']")));
        WebElement MailboxIntegration6 = Driver.getDriver().findElement(By.xpath("//div[@class='mail-msg-sidepanel-title']"));
        Assert.assertTrue(MailboxIntegration6.isDisplayed());
        Driver.getDriver().switchTo().parentFrame();
        WebElement CloseButton6 = Driver.getDriver().findElement(By.xpath("//span[@class='side-panel-close-inner']"));
        CloseButton6.click();

        Aol.click();
        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//iframe[@src='/mail/config/new?id=7&IFRAME=Y&IFRAME_TYPE=SIDE_SLIDER']")));
        WebElement MailboxIntegration7 = Driver.getDriver().findElement(By.xpath("//div[@class='mail-msg-sidepanel-title']"));
        Assert.assertTrue(MailboxIntegration7.isDisplayed());
        Driver.getDriver().switchTo().parentFrame();
        WebElement CloseButton7 = Driver.getDriver().findElement(By.xpath("//span[@class='side-panel-close-inner']"));
        CloseButton7.click();

        Imap.click();
        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//iframe[@src='/mail/config/new?id=8&IFRAME=Y&IFRAME_TYPE=SIDE_SLIDER']")));
        WebElement MailboxIntegration8 = Driver.getDriver().findElement(By.xpath("//div[@class='mail-msg-sidepanel-title']"));
        Assert.assertTrue(MailboxIntegration8.isDisplayed());
        Driver.getDriver().switchTo().parentFrame();
        WebElement CloseButton8 = Driver.getDriver().findElement(By.xpath("//span[@class='side-panel-close-inner']"));
        CloseButton8.click();

        BrowsersUtils.sleep(1);



    }
}
