package com.veeva.automation.api;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class UserApiTest extends ApiBaseTest {

    @Test
    public void getUsers_shouldReturn200() {

        Response response =
                given()
                        .when()
                        .get("/users?page=2")
                        .then()
                        .statusCode(200)
                        .extract().response();

        Assert.assertNotNull(response.jsonPath().get("data"));
    }
}
