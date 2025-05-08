package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class API_Lab024_TestNG_dependsOnMethods {

    // dependsOnMethods will help run test cases only if that is executed
    // some testcase might be dependent upon few other testcases to be executed

     @Test
    public void serverStartedOk() {
        System.out.println("I will run first");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "serverStartedOk")
    public void test1() {
        System.out.println("method1");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "serverStartedOk")
    public void test2() {
        System.out.println("method2");
        Assert.assertTrue(true);
    }
}
