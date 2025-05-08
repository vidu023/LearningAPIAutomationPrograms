package com.thetestingacademy.ex_05_TestNGExamples;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class API_Lab021_TestNG_Before_AfterTest {

    // @BeforeTest will run all te testcases before @Test runs
    // it will run alphabetically i.e. getBookingID() will be executed 1st

    // PUT Request -
    // 1. getToken
    // 2. getBookingId
    // 3. test_PUT ( which will use the above two methods)
    // 4. closeAllThings

    @BeforeTest
    public void getToken(){
        System.out.println("@BeforeTest_GET Token");
    }

    @BeforeTest
    public void getBookingID(){
        System.out.println("@BeforeTest_GET BOOKING ID");
    }

    @Test
    public void test_PUT(){
        // token and BookingID
        System.out.println("@Test_PUT REQUEST");
    }

    @AfterTest
    public void closeAllThings(){
        System.out.println("Close");
    }
}
