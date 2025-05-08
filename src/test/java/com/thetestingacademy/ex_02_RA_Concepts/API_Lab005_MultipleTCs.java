package com.thetestingacademy.ex_02_RA_Concepts;

import io.restassured.RestAssured;

public class API_Lab005_MultipleTCs {
    public static void main(String[] args) {

        // TC: 1 - Valid pincode
        String pinCode = "400067";
        RestAssured.given()
                        .baseUri("https://api.zippopotam.us")
                        .basePath("/IN/"+pinCode)
                .when()
                        .get()
                .then()
                        .log().all().statusCode(200);

        // TC: 2 - Invalid pincode
        pinCode = "12345";
        RestAssured.given()
                        .baseUri("https://api.zippopotam.us")
                        .basePath("/IN/"+pinCode)
                .when()
                        .get()
                .then()
                        .log().all().statusCode(200);

        // TC: 3 - Blank pincode
        pinCode = " ";
        RestAssured.given()
                        .baseUri("https://api.zippopotam.us")
                        .basePath("/IN/"+pinCode)
                .when()
                        .get()
                .then()
                        .log().all().statusCode(200);

    }
}
