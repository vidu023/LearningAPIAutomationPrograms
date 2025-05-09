package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.annotations.Test;

public class API_Lab028_TestNG_InvocationCount {

    // invocationCount acts like iteration
    // it will be executed that many times if the count is given

     @Test(invocationCount = 2)
    public void test01(){
        System.out.println("Hi");
    }

    // by default executed once
    @Test()
    public void test03(){
        System.out.println("Good Morning");
    }

    @Test(invocationCount = 3)
    public void test02(){
        System.out.println("Bye");
    }
}
