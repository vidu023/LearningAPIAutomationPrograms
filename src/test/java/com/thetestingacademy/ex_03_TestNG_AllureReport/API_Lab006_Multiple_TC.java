package com.thetestingacademy.ex_03_TestNG_AllureReport;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class API_Lab006_Multiple_TC {

    String pinCode = "400067";

    @Test
    public void ValidTC_1(){
        pinCode = "400053";
        RestAssured.given()
                        .baseUri("https://api.zippopotam.us")
                        .basePath("/IN/"+pinCode)
                .when()
                        .get()
                .then()
                        .log().all().statusCode(200);
    }

    @Test
    public void InvalidTC_02(){
    pinCode = "ABCD";
        RestAssured.given()
                        .baseUri("https://api.zippopotam.us")
                        .basePath("/IN/"+pinCode)
                .when()
                        .get()
                .then()
                        .log().all().statusCode(200);
    }

    @Test
    public void InvalidTC_03(){
    pinCode = " ";
        RestAssured.given()
                        .baseUri("https://api.zippopotam.us")
                        .basePath("/IN/"+pinCode)
                .when()
                        .get()
                .then()
                        .log().all().statusCode(200);
    }

}


