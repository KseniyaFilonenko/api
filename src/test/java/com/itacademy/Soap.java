package com.itacademy;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Soap {
    @Test
    public void soapTest() {
        given().contentType("application/soap+xml").body("")
                .when().post("https://www.dataaccess.com/webserviceserver/numberconversion.wso")
                .then().log().all().statusCode(200).extract().response();
    }
}
