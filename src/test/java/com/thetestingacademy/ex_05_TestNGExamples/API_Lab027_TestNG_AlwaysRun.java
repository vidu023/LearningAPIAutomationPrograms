package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class API_Lab027_TestNG_AlwaysRun {

     @Test
    public void test_new_register() {
        Assert.assertTrue(true);
    }

    // this will always be executed if its true
    // but if enabled is false  & alwaysRun is true also -> in this case it will not be executed
    @Test(alwaysRun = true)
    //@Test(alwaysRun = true, enabled = false)
    public void test_loginPage() {
        Assert.assertTrue(true);
    }

    @Test
    public void test_normal() {
        Assert.assertTrue(true);
    }
}
