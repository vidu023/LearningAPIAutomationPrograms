package com.thetestingacademy.ex_03_TestNG_AllureReoprt;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class API_Lab006_Multiple_TC {
    String pincode = "110048";

    @Test
    public void test_GET_POSITIVE_TC1() {
        pincode = "110048";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);

    }

    @Test
    public void test_GET_NEGATIVE_TC2() {
        pincode = "@";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);
    }

    @Test
    public void test_GET_NEGATIVE_TC3() {
        pincode = " ";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/USA/" + pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);

    }


}