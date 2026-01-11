package com.veeva.automation.api;

import com.veeva.automation.config.ConfigReader;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class ApiBaseTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI =
                ConfigReader.get("api.base.url");
    }
}
