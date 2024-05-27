package com.itacademy;

import java.io.File;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

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
        File file = new File("src/test/resources/json/newTile.json");
        given().log().all().contentType(ContentType.JSON).body(file)
                .when().post("/posts")
                .then().log().body().statusCode(201);
    }
    @Test
    public void putNewID() {
        File file = new File("src/test/resources/json/putNewID.json");
        given().log().all().contentType(ContentType.JSON).body(file)
                .when().put("/posts/1")
                .then().log().body().statusCode(200);
    }
    @Test
    public void deletePost() {
        given().log().all()
                .when().delete("/posts/1")
                .then().log().body().statusCode(200);
    }
    @Test
    public void getPostsResponse() {
        Response response = given().log().all()
                .when().get("/posts")
                .then().log().all().extract().response();
        assertEquals(response.statusCode(), 200);
        assertEquals(response.getHeader("Transfer-Encoding"), "chunked");
    }
    @Test
    public void getOnePostResponse() {
        Response response = given().log().all()
                .when().get("/posts/1")
                .then().log().all().extract().response();
        assertEquals(response.jsonPath().getString("title"), "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
        assertEquals(response.jsonPath().getInt("userId"), 1);
    }
}
