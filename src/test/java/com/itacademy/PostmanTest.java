package com.itacademy;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostmanTest {
    @BeforeTest
    public void setUp() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }
    @Test
    public void getPosts() {
        given().log().all()
                .when().get("/posts")
                .then().log().body().statusCode(200);
    }
    @Test
    public void getOnePost() {
        given().log().all()
                .when().get("/posts/1")
                .then().log().body().statusCode(200);
    }
    @Test
    public void postNewTitle() {
        given().log().all().contentType(ContentType.JSON).body("{\n" +
                "    \"title\": \"foo\",\n" +
                "    \"body\": \"bar\",\n" +
                "    \"userId\": 1\n" +
                "  }")
                .when().post("/posts")
                .then().log().body().statusCode(201);
    }
    @Test
    public void putNewID() {
        given().log().all().contentType(ContentType.JSON).body("{\n" +
                "    \"id\": 1,\n" +
                "    \"title\": \"foo\",\n" +
                "    \"body\": \"bar\",\n" +
                "    \"userId\": 1\n" +
                "}")
                .when().put("/posts/1")
                .then().log().body().statusCode(200);
    }
    @Test
    public void deletePost() {
        given().log().all()
                .when().delete("/posts/1")
                .then().log().body().statusCode(200);
    }
}
