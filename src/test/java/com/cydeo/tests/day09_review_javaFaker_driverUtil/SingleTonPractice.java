package com.cydeo.tests.day09_review_javaFaker_driverUtil;

import org.testng.annotations.Test;

public class SingleTonPractice {

    @Test
    public void singleton_understanding_test1(){

        String str1 = SingleTon.getWord();
        System.out.println("str1 = " + str1);

        String str2 = SingleTon.getWord();
        System.out.println("str2 = " + str2);

        String str3 = SingleTon.getWord();
        System.out.println("str3 = " + str3);
    }
}
