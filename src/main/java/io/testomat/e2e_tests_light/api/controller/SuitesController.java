package io.testomat.e2e_tests_light.api.controller;

import io.restassured.response.Response;
import io.testomat.e2e_tests_light.api.dto.SuiteRequest;

public class SuitesController extends BaseController<SuitesController> {

    public Response createTestSuiteForProject(final String projectName, final SuiteRequest suiteRequest) {
        return getRequestSpecification()
                .body(suiteRequest)
                .pathParam("projectName", projectName)
                .post("/{projectName}/suites");
    }

    public Response getSuitesForProject(final String projectName) {
        return getRequestSpecification()
                .pathParam("projectName", projectName)
                .get("/{projectName}/suites");
    }

    public Response deleteSuiteForProject(final String projectName, final String suiteId) {
        return getRequestSpecification()
                .pathParam("projectName", projectName)
                .pathParam("suiteId", suiteId)
                .delete("/{projectName}/suites/{suiteId}");
    }

}