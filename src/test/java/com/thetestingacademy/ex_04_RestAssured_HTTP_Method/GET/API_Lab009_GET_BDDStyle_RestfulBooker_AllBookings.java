package com.thetestingacademy.ex_04_RestAssured_HTTP_Method.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class API_Lab009_GET_BDDStyle_RestfulBooker_AllBookings {

        @Test
                public void test_AllBooking_RestfulBooker(){

        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/booking/")
                .when()
                    .get()
                .then()
                    .log().all().statusCode(200);
    }
}
