package com.itacademy;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RESTAssuredTest {
    @BeforeTest
    public void setUp() {
        RestAssured.baseURI = "https://reqres.in";
    }
    @Test
    public void getTestRequest() {
        given().log().all()
         .when().get("/api/users/2")
         .then().log().all().statusCode(200);
    }
    @Test
    public void createUserId() {
        //File file = new File("src/test/resources/test.json");
        given().log().all().contentType(ContentType.JSON).body("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}")
                .when().post("/api/users")
                .then().log().body().statusCode(201);
    }
    @Test
    public void updateUser() {
        Map<String, String> bodyInfo = new HashMap<>();
        bodyInfo.put("name", "new name");
        bodyInfo.put("job", "new job");
        given().log().all().contentType(ContentType.JSON).body(bodyInfo)
                .when().put("/api/users/2")
                .then().log().body().statusCode(200);
    }
    @Test
    public void deleteUser() {
        given().log().uri()
                .when().delete("/api/users/2")
                .then().statusCode(204);
    }
    @Test
    public void getResponse() {
        given().log().all()
                .when().get("/api/users/2")
                .then().extract().response();
    }
}
