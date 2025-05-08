package com.thetestingacademy.ex_04_RestAssured_HTTP_Method.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class API_Lab014_POST_NonBDDStyle_RestfulBooker_CreateToken {

    // https://restful-booker.herokuapp.com/auth
        // {
        //    "username" : "admin",
        //    "password" : "password123"
        //}

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RequestSpecification rs;
        Response r;
        ValidatableResponse vr;

    @Test
    public void test_Post_CreateToken_RestfulBooker(){

        // Part 1 - Pre Condition - Preparing Request - URL, Headers, Auth... (Given)
        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/auth");
        rs.contentType(ContentType.JSON); // content type
        rs.body(payload).log().all();

        System.out.println(" ----    Part 2 ---- ");

        // Making HTTP Request -> Part 2
        r = rs.when().log().all().post();


        System.out.println(" ----    Part 3 ---- ");

        // Verification Part -> Part 3
        vr = r.then().log().all();
        vr.statusCode(200);


    }
}
