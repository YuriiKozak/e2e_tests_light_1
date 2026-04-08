package io.testomat.e2e_tests_light.api.controller;

import io.restassured.response.Response;

public class LoginController extends BaseController<LoginController> {

    public Response loginUserAndGetJwtToken(final String username, final String password) {
        return getTestomatApi()
                .formParam("email", username)
                .formParam("password", password)
                .post("/login");
    }

}