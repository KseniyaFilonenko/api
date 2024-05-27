package com.itacademy;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class xmlTest {
    @Test
    public void validateXML() {
        Response response = given()
                .when().get("https://mocktarget.apigee.net/xml")
                .then().statusCode(200).log().all().extract().response();
        assertEquals(response.xmlPath().getString("root.city"), "San Jose");

    }
}
