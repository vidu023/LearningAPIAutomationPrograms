package com.thetestingacademy.ex_04_RestAssured_HTTP_Method.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class API_Lab007_GET_BDDStyle_IN_ZipCode {

        @Test
        public void test_GET_Positive_Zipcode(){
            String pinCode = "400067";
            RestAssured
                    .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/" + pinCode)
                    .when()
                    .get()
                    .then()
                    .log().all().statusCode(200);
        }
}
