package com.thetestingacademy.ex_04_RestAssured_HTTP_Method.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class API_Lab016_POST_NonBDDStyle_RestfulBooker_CreateBooking {

    // https://restful-booker.herokuapp.com/booking

    String payload = "{\n" +
            "    \"firstname\" : \"Jim\",\n" +
            "    \"lastname\" : \"Brown\",\n" +
            "    \"totalprice\" : 111,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";

    RequestSpecification rs;
    Response r;
    ValidatableResponse vr;

    @Test
    public void test_NonBDD_RestfulBooker_CreateBooking(){

        // Given
        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking");
        rs.contentType(ContentType.JSON);
        rs.body(payload);

        // When
        r = rs.when().post();

        //Then
        vr = r.then().log().all().statusCode(200);
    }
}
