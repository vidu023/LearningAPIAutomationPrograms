package com.thetestingacademy.ex_06_TestNG_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class API_Lab032_TestNG_Assertions {

    // Hard Assertion

     @Test
    public void test_hardAssertExample() {
        System.out.println("Start of the program");
        Assert.assertEquals("pramod","Pramod");
        System.out.println("End of the program");
    }

    // Soft Assertion

    @Test (enabled = false) // this means to comment of this code & execute above Test case
    public void test_softAssertExample() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("pramod","Pramod");
        System.out.println("End of program");
        softAssert.assertAll();
    }
}
