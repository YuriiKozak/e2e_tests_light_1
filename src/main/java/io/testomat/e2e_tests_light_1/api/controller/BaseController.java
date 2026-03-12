package io.testomat.e2e_tests_light_1.api.controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.testomat.e2e_tests_light_1.utils.EnvConfig.URL;

public abstract class BaseController<T> {

    private String jwtToken;

    protected RequestSpecification getTestomatApi() {
        return RestAssured.given()
                .baseUri(URL)
                .basePath("/api");
    }

    protected RequestSpecification getRequestSpecification() {
        final RequestSpecification requestSpecification = getTestomatApi()
                .contentType(ContentType.JSON);

        if (jwtToken != null) {
            requestSpecification.header("Authorization", jwtToken);
        }

        return requestSpecification;
    }

    @SuppressWarnings("unchecked")
    public T withToken(final String jwtToken) {
        this.jwtToken = jwtToken;
        return (T) this;
    }

}