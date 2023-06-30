package com.cydeo.tests.day09_review_javaFaker_driverUtil;

public class SingleTon {

    //#1 Create private constructor
    private SingleTon(){

    }
    //#2 Private static String
    private static String word; // by default word is null

    //#3- Utility method to return the 'private String' we just created
public static String getWord(){
    if (word == null) {
        System.out.println("First time call, word object is null");
        System.out.println("Assigning value to it now");
        word = "something";
    }else{
        System.out.println("Word already has a value");
    }
    return word;
}





}
