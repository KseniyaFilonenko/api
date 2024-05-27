package com.itacademy;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class jsonSchemaTest {
    @BeforeTest
    public void setUp() {
        RestAssured.baseURI = "https://reqres.in";
    }
    @Test
    public void validateSchema() {
        given().log().all()
                .when().get("api/users/2")
                .then().log().all().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("json/jsonschema.json"));
    }
    @Test
    public void validateSchemaFromMyPostman() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        given().log().all()
                .when().get("/posts/1")
                .then().log().all().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("json/jsonschemaPostman.json"));
    }
}
