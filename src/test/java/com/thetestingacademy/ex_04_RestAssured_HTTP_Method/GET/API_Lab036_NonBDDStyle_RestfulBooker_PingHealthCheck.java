package com.thetestingacademy.ex_04_RestAssured_HTTP_Method.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class API_Lab036_NonBDDStyle_RestfulBooker_PingHealthCheck {

    RequestSpecification rs;
    Response r;
    ValidatableResponse vr;

    @Test
    public void test_GET_RestfulBooker_PingHealthCheck(){

        //Given
        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/ping");

        //When
        r = rs.when().get();

        //Then
        vr = r.then().log().all().statusCode(201);
    }
}
