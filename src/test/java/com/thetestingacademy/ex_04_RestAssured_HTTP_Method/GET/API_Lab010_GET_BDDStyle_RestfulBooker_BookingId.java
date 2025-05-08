package com.thetestingacademy.ex_04_RestAssured_HTTP_Method.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class API_Lab010_GET_BDDStyle_RestfulBooker_BookingId {

    @Test
    public void test_BookingId_RestfulBooker(){

        String bookingId = "13";
        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/booking/"+ bookingId)
                .when()
                    .get()
                .then()
                    .log().all().statusCode(200);
    }
}
