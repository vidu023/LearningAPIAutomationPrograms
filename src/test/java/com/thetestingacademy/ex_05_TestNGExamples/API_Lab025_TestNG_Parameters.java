package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class API_Lab025_TestNG_Parameters {

    // so based upon the parameter when xml file is executed, accordingly the statements will be executed
    // so no writing different testcases for eg different browser or different env

    // it takes input values from the XML File& give to TestNG Testcases as parameters

    @Parameters("browser")
    @Test
    public void demo1(String value) {
        System.out.println("Hi I am demo");
        System.out.println("You are running this parameter");

        if (value.equalsIgnoreCase("firefox")) {
            System.out.println("Start the Firefox Browser");
        }
        if (value.equalsIgnoreCase("chrome")) {
            System.out.println("Start the Chrome Browser!");
        }
    }
}
