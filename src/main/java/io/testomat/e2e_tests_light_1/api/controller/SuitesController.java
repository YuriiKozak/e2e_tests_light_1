package io.testomat.e2e_tests_light_1.api.controller;

import io.restassured.response.Response;
import io.testomat.e2e_tests_light_1.api.dto.SuiteRequest;

public class SuitesController extends BaseController {

    public Response createTestSuiteForProject(final String projectName, final SuiteRequest suiteRequest,
                                              final String jwtToken) {
        return getTestomatApi(jwtToken)
                .body(suiteRequest)
                .pathParam("projectName", projectName)
                .post("/{projectName}/suites");
    }

    public Response getSuitesForProject(final String projectName, final String jwtToken) {
        return getTestomatApi(jwtToken)
                .pathParam("projectName", projectName)
                .get("/{projectName}/suites");
    }

    public Response deleteSuiteForProject(final String projectName, final String suiteId, final String jwtToken) {
        return getTestomatApi(jwtToken)
                .pathParam("projectName", projectName)
                .pathParam("suiteId", suiteId)
                .delete("/{projectName}/suites/{suiteId}");
    }

}