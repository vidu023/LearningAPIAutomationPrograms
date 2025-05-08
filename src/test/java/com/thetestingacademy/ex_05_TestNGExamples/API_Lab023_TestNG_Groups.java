package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class API_Lab023_TestNG_Groups {

    // sanity - 1
    // regression -> 3
    // smoke -> 2

    //we need to create multiple xml files to run these which will have include exclude functions
    // its corresponding xml files are available under pom.xml

    @Test(groups = {"Sanity", "Regression"}, priority = 1)
    public void test_sanityRun() {
        System.out.println("Sanity");
        System.out.println("QA");
        Assert.assertTrue(true);
    }

    @Test(groups = {"Regression"}, priority = 2)
    public void test_regRun() {
        System.out.println("Regression");
        Assert.assertTrue(true);
    }

    @Test(groups = {"Smoke","Regression"},priority = 3)
    public void test_smokeRun() {
        System.out.println("Smoke");
        Assert.assertTrue(true);
    }
}
