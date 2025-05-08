package com.thetestingacademy.ex_04_RestAssured_HTTP_Method.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class API_Lab013_POST_BDDStyle_RestfulBooker_CreateToken {

        // https://restful-booker.herokuapp.com/auth
        // {
        //    "username" : "admin",
        //    "password" : "password123"
        //}

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

    @Test
    public void test_CreateToken_RestfulBooker(){

        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/auth")
                    .contentType(ContentType.JSON) // content type
                    .log().all()
                    .body(payload) // body needs to enter payload for Post request
                .when()
                    .post()
                .then()
                .log().all().statusCode(200);

    }

}
