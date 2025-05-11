package com.thetestingacademy.ex_04_RestAssured_HTTP_Method.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class API_Lab_018_NonBDD_PATCH_RestfulBooker_UpdatePartialBooking {

    // https://restful-booker.herokuapp.com/booking/:id

    String bookingId = "3999";
    String token = "0d45427af9612e7";
    String payload = "{\n" +
            "    \"firstname\" : \"Charles\",\n" +
            "    \"lastname\" : \"Bing\"\n" +
            "}";

    RequestSpecification rs;
    Response r;
    ValidatableResponse vr;

    @Test
    public void test_PATCH_RestfulBooker_UpdatePartialBooking(){
        // Given
        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/" + bookingId);
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);
        rs.body(payload).log().all();

        // When
        r = rs.when().patch();

        //Then
        vr = r.then().log().all().statusCode(200);
    }
    }

