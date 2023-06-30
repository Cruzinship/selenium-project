package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.BrowsersUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Upload_Practice {
    //TC #2 Upload Test
    @Test
    public void Uploading_Test() {
        //1. Go to https://practice.cydeo.com/upload
        Driver.getDriver().get("https://practice.cydeo.com/upload");
        // 2. Find some small file from your computer, and get the path of it.
        String path = "C:\\Users\\Gianpaulo\\OneDrive\\Desktop\\file.txt";
         /*
        Windows path option #1: C:\\Users\\hayat\\Desktop\\note.txt
        Windows path option #2: C://Users/hayat/Desktop/note.txt
         */

        //    //3. Upload the file.
        WebElement chooseFileButton = Driver.getDriver().findElement(By.id("file-upload"));
        BrowsersUtils.sleep(2);

        //This is the line that is passing the path of the file to website
        chooseFileButton.sendKeys(path);
        //chooseFileButton.sendKeys("/Users/gurhan/Desktop/file.txt");

        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));
        uploadButton.click();
        //    //4. Assert:
        //    //-File uploaded text is displayed on the page
        WebElement fileUploadedHeader = Driver.getDriver().findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedHeader.isDisplayed(), "Header text is not displayed");
    }

}
