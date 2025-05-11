package com.thetestingacademy.ex_04_RestAssured_HTTP_Method.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class API_Lab_019_NonBDD_DELETE_RestfulBooker_DeleteBooking {

    // https://restful-booker.herokuapp.com/booking/:id

    String bookingId = "3999";
    String token = "0d45427af9612e7";

    RequestSpecification rs;
    Response r;
    ValidatableResponse vr;

    @Test
    public void test_DELETE_RestfulBooker_DeleteBooking(){
        // Given
        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/" + bookingId);
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);

        // When
        r = rs.when().delete();

        //Then
        vr = r.then().log().all().statusCode(201);
    }
    }

