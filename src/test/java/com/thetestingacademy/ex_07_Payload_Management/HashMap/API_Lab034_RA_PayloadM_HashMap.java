package com.thetestingacademy.ex_07_Payload_Management.HashMap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class API_Lab034_RA_PayloadM_HashMap {

    RequestSpecification rs;
    Response r;
    ValidatableResponse vr;

    String token;
    Integer bookingId;

    @Test
    public void test_POST_RestfulBooker() {

        /*
        String payload_POST = "{\n" +
                "    \"firstname\" : \"Vidya\",\n" +
                "    \"lastname\" : \"Kini\",\n" +
                "    \"totalprice\" : 123,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";
                */

        // Hashmap -> Key and Value
        // we are using LinkedHashMAp as we want to maintain the order of insertion

        // Parent Hashmap
        Map<String, Object> jsonBodyUsingMap = new LinkedHashMap<>();
        jsonBodyUsingMap.put("firstname", "Vidya");
        jsonBodyUsingMap.put("lastname", "Kini");
        jsonBodyUsingMap.put("totalprice", 123);
        jsonBodyUsingMap.put("depositpaid", false);

        // Child HashMap -> BookingDates
        Map<String, Object> bookingDatesMap = new LinkedHashMap();
        bookingDatesMap.put("checkin", "2018-01-01");
        bookingDatesMap.put("checkout", "2019-01-01");

        // Inserting Child HashMap into Parent
        jsonBodyUsingMap.put("bookingdates", bookingDatesMap);

        jsonBodyUsingMap.put("additionalneeds", "Breakfast");
        System.out.println(jsonBodyUsingMap);


        // HashMap Output looks similar to json but its not json
        // we need to convert it into json using any one of 2 popular libraries
        // gson -> Google library -> it can help convert map, class & multiple things to json
        // & jackson

        // Request Specification -> given()
        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com/");
        rs.basePath("/booking");
        rs.contentType(ContentType.JSON);
        rs.body(jsonBodyUsingMap).log().all(); // we shall be passing this Map Object in body
        // it will automatically convert HashMap -> json using gson library after adding the dependency

        // Response -> when()
        r = rs.when().post();


        // Get Validatable response to perform validation
        vr = r.then().log().all();
        vr.statusCode(200);

        // Rest Assured -> import org.hamcrest.Matchers; %4-%5
        // Matchers.equalto()

        vr.body("booking.firstname", Matchers.equalTo("Vidya"));
        vr.body("booking.lastname", Matchers.equalTo("Kini"));
        vr.body("booking.depositpaid", Matchers.equalTo(false));
        vr.body("bookingid", Matchers.notNullValue());


    }

}
