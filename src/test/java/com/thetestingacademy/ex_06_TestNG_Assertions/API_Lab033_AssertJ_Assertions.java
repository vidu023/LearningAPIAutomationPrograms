package com.thetestingacademy.ex_06_TestNG_Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
// import static org.assertj.core.api.Assertions.*;

public class API_Lab033_AssertJ_Assertions {

    RequestSpecification rs;
    Response r;
    ValidatableResponse vr;

    String token;
    Integer bookingId;

    @Test
    public void test_POST_RestfulBooker() {

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


        // Request Specification -> given()
        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com/");
        rs.basePath("/booking");
        rs.contentType(ContentType.JSON);
        rs.body(payload_POST).log().all();

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


        // TestNG - Extract the details of the firstname, bookingId, lastname from Response.

        bookingId = r.then().extract().path("bookingid");
        String firstname = r.then().extract().path("booking.firstname");
        String lastname = r.then().extract().path("booking.lastname");



        // TestNG Assertions - 75%
        // HardAssert - This means that if any assertion fails,
        // the remaining statements in that test method will not be executed.
        Assert.assertEquals(firstname,"Vidya");
        Assert.assertEquals(lastname,"Nayak");
        Assert.assertNotNull(bookingId);



        // AssertJ( 3rd- Lib to Assertions) - 20%
        // builder method
        // can use many assertions in a single line using '.'
        assertThat(bookingId).isNotZero().isNotNull().isPositive();
        assertThat(firstname).isEqualTo("Pramod").isNotBlank().isNotEmpty().isNotNull().isAlphanumeric();

        // String s1 = ""; // this means Empty
        // String s2 = " "; // this means Blank

    }

}
