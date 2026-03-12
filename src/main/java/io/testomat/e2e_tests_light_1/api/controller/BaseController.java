package io.testomat.e2e_tests_light_1.api.controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.testomat.e2e_tests_light_1.utils.EnvConfig.URL;

public abstract class BaseController {

    protected RequestSpecification getTestomatApi() {
        return RestAssured.given()
                .accept(ContentType.JSON)
                .baseUri(URL)
                .basePath("/api")
                .log().all();
    }

    protected RequestSpecification getTestomatApi(final String jwtToken) {
        return getTestomatApi()
                .header("Authorization", jwtToken)
                .contentType(ContentType.JSON);
    }

}