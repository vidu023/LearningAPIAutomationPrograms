package com.thetestingacademy.ex_04_RestAssured_HTTP_Method.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class API_Lab012_GET_NonBDDStyle_RestfulBooker_BookingId {

        RequestSpecification rs;
        Response r;
        ValidatableResponse vr;

        @Test
        public void test_GET_RestfulBooker_BookingId() {

        String bookingId = "1200";

        //Given
        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking" + bookingId);

        //When
        r = rs.when().get();

        //Then
        vr = r.then().log().all().statusCode(200);
    }

    @Test
    public void test_GET_Negative_RestfulBooker_Booking(){

        String bookingId = "585";

        //Given
        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking" + bookingId);

        //When
        r = rs.when().get();

        //Then
        vr = r.then().log().all().statusCode(404);
    }
}

