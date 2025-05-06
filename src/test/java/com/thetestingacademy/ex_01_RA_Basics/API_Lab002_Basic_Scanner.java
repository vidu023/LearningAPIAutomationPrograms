package com.thetestingacademy.ex_01_RA_Basics;

import io.restassured.RestAssured;

import java.util.Scanner;

public class API_Lab_002 {
    public static void main(String[] args) {

        // Gherkins Syntax
        // Given() -> Pre Req. - URL, Headers, Auth, Body....
        // When() -> HTTP method? - GET/POST/PUT/PATCH, DELETE...
        // Then() -> Validation -> 200 oK, firstname == PRAMOD

        // Full URL - https://api.zippopotam.us/IN/560016
        // base URI - https://api.zippopotam.us
        // base Path - /IN/560016 i.e. IN is the endpoint

        // We can ask the pinCode from the user by using Scanner class
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a 6 digit pincode");
        String pinCode = scanner.next();


        RestAssured.given()
                        .baseUri("https://api.zippopotam.us")
                        .basePath("/IN/"+pinCode)
                .when()
                        .get()
                .then()
                        .log().all().statusCode(200);

    }
}
