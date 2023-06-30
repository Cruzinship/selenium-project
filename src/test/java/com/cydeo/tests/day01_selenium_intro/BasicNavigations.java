package com.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException {
//SetUp browser Driver
        WebDriverManager.chromedriver().setup();

        //Create Instance of Chrome browser
        WebDriver driver = new ChromeDriver();

        //This line will maximize the currently opened browser
        driver.manage().window().maximize();
        // only for mac driver.manage().window().fullscreen();

        // Go to Tesla.com
        driver.get("http://tesla.com");

        //get title of page
        //System.out.println("driver.getTitle() = " +driver.getTitle());

String currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        //Go back
        driver.navigate().back();

        //stop execution for 3 seconds
       Thread.sleep(1000);

        //User navigate forward() to go forward
        driver.navigate().forward();

        //stop execution for 3 seconds
        Thread.sleep(1000);

        //User navigate refresh() the page
        driver.navigate().refresh();

        //stop execution for 3 seconds
        Thread.sleep(1000);

        //navigate to google.com using navigate().to();
        driver.navigate().to("https://www.google.com");

        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());


        //System.out.println("driver.getTitle() = " +driver.getTitle());
        //get title of page
        currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        driver.close();

        driver.quit();


    }
}
