package io.testomat.e2e_tests_light_1.api.controller;

import io.restassured.response.Response;

public class ProjectsController extends BaseController {

    public Response getProjects(final String jwtToken) {
        return getTestomatApi(jwtToken)
                .get("/projects");
    }

}