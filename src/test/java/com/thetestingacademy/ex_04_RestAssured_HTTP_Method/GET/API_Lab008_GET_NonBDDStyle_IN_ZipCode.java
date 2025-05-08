package com.thetestingacademy.ex_04_RestAssured_HTTP_Method.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class API_Lab008_GET_NonBDDStyle_IN_ZipCode {

    // Interfaces
    RequestSpecification rs;
    Response r;
    ValidatableResponse vr;


    @Test
    public void test_GET_Positive_ZipCode(){

         String pinCode = "400067";
        // each are individual statements & we do not require ..

        //Given
        rs = RestAssured.given();
        rs.baseUri("https://api.zippopotam.us"); // it can be called later  using the reference
        rs.basePath("/IN/" + pinCode);

        //When
        //r = rs.when().get();
        r = rs.when().log().all().get();
        System.out.println("Response: "+r.asString());

        //Then
        vr = r.then().log().all();
        vr.statusCode(200);
    }

    @Test
    public void test_GET_Negative_ZipCode(){

        // each are individual statements & we do not require ..
        // here you can complete the sentence by ";" instead of chaining
        // nonBDD is scalable approach i.e I can resuse the code

         String pinCode = "400053"; // pincode not present

        //Given
        rs = RestAssured.given();
        rs.baseUri("https://api.zippopotam.us"); // it can be called later  using the reference
        rs.basePath("/IN/" + pinCode);

        //When
        //r = rs.when().get();
        r = rs.when().log().all().get();
        System.out.println("Response: "+r.asString());

        //Then
        vr = r.then().log().all();
        vr.statusCode(404);
    }
}
