package io.testomat.e2e_tests_light_1.api.controller;

import io.restassured.response.Response;

public class ProjectsController extends BaseController<ProjectsController> {

    public Response getProjects() {
        return getRequestSpecification()
                .get("/projects");
    }

}