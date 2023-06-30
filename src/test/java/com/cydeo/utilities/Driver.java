package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    //create a private constructor to remove acess to this object

    private Driver(){}
    /*
    We make the webdriver private because we want to close access from outside the class
    We are making it static, because we will use it in a static method.
     */
    private static WebDriver driver; //default value = null

    /*
    Create a re-usable utility method which will return the same driver instance once we call it.
    - If an instance doesn't exist, it will create first, and it will always return same instance
     */
    public static WebDriver getDriver(){
/*
We will read our browser type from configuration properties file
This way, we can control which browser is opened from outside our code.
 */
        if (driver == null){
            String browserType = ConfigurationReader.getProperty("browser");
/*
Depending on the browserType returned from the configuration.properties
switch statement will determine the "case", and open the matching browser
 */
            switch (browserType){
                case "chrome":
                    ChromeOptions co = new ChromeOptions();
                    co.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(co);
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            }
        }

        return driver;

        /*
        Create a new Driver.closeDriver(); it will use .quit() method to quit browsers, and then ste the driver back to null.
         */
    }

    public static void closeDriver(){
        if (driver !=null){
            /*
            This line will terminate the currently existing driver completely, It will not exist going forward
             */
            driver.quit();
            driver = null;
        }
    }
}
