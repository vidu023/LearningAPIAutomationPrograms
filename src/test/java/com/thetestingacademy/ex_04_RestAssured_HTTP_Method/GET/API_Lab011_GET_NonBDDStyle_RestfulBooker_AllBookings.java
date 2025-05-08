package com.thetestingacademy.ex_04_RestAssured_HTTP_Method.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class API_Lab011_GET_NonBDDStyle_RestfulBooker_AllBookings {

    RequestSpecification rs;
    Response r;
    ValidatableResponse vr;

    @Test
    public void test_GET_Positive_RestfulBooker_Booking(){

        //Given
        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking");

        //When
        r = rs.when().get();

        //Then
        vr = r.then().log().all().statusCode(200);
    }
}
