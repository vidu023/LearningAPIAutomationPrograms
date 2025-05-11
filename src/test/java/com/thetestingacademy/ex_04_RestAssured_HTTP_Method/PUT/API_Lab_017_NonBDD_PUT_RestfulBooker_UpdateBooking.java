package com.thetestingacademy.ex_04_RestAssured_HTTP_Method.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class API_Lab_017_NonBDD_PUT_RestfulBooker_UpdateBooking {

    // https://restful-booker.herokuapp.com/booking/:id

    String bookingId = "4595";
    String token = "0d45427af9612e7";
    String payload = "{\n" +
            "    \"firstname\" : \"James\",\n" +
            "    \"lastname\" : \"Patterson\",\n" +
            "    \"totalprice\" : 1000,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2025-01-01\",\n" +
            "        \"checkout\" : \"2026-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Lunch\"\n" +
            "}";

    RequestSpecification rs;
    Response r;
    ValidatableResponse vr;

    @Test
    public void test_PUT_RestfulBooker_UpdateBooking(){
        // Given
        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/" + bookingId);
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);
        rs.body(payload).log().all();

        // When
        r = rs.when().put();

        //Then
        vr = r.then().log().all().statusCode(200);
    }
    }

