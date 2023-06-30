package com.cydeo.tests.day05_testNG_intro_dropdowns;

import org.apache.hc.core5.reactor.Command;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_intro {
    @BeforeClass
    public void setUpClass(){
        System.out.println("-->Before class is running");
    }

    @BeforeMethod
    public void setUpMethod(){
        System.out.println("--> Before method is running...");
    }
    @AfterClass
    public void tearDownClass(){
        System.out.println("----> After class is running!!!");
    }

    @AfterMethod
    public void tearDownMethod(){
        System.out.println("--> After method is running");


    }
    @Test (priority = 1)
    public void test1() {
        System.out.println("Test 1 is running...");
//Assert equals method will compare the two, if they pass they are equal
        String actual = "apple";
        String expected = "apple";
        Assert.assertEquals(actual, expected);
    }
   @Test (priority = 2)
    public void test2(){
        System.out.println("Test 2 is running...");
       String actual = "white";
       String expected = "white";

       Assert.assertTrue(actual.equals(expected));
    }
}
