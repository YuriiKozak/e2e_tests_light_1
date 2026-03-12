package io.testomat.e2e_tests_light_1.api;

import io.testomat.e2e_tests_light_1.api.controller.LoginController;
import io.testomat.e2e_tests_light_1.api.controller.ProjectsController;
import io.testomat.e2e_tests_light_1.api.controller.SuitesController;
import io.testomat.e2e_tests_light_1.api.dto.ProjectsResponse;
import io.testomat.e2e_tests_light_1.api.dto.SuiteRequest;
import io.testomat.e2e_tests_light_1.api.dto.SuitesResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.testomat.e2e_tests_light_1.utils.EnvConfig.EMAIL;
import static io.testomat.e2e_tests_light_1.utils.EnvConfig.PASSWORD;
import static org.assertj.core.api.Assertions.assertThat;

public class CreateTestSuiteTest extends BaseTest {

    @Test
    @DisplayName("Test: Login User And Create Test Suite")
    public void loginUserAndCreateTestSuite() {

        // login user and get jwt token
        final String jwtToken = new LoginController()
                .loginUserAndGetJwtToken(EMAIL, PASSWORD)
                .then().statusCode(200)
                .extract().jsonPath().getString("jwt");

        // get projects
        final ProjectsResponse projectsResponse = new ProjectsController()
                .getProjects(jwtToken)
                .then().statusCode(200)
                .extract().as(ProjectsResponse.class);

        assertThat(projectsResponse.data().stream().map(project ->
                project.attributes().title()).toList()).contains(AUTOMOTIVE);

        final SuitesController suitesController = new SuitesController();

        // create suite
        final String title = "Test - " + System.currentTimeMillis();
        suitesController
                .createTestSuiteForProject(AUTOMOTIVE, suiteRequest(title), jwtToken)
                .then().statusCode(200);

        // get suites
        final SuitesResponse suitesResponse = suitesController
                .getSuitesForProject(AUTOMOTIVE, jwtToken)
                .then().statusCode(200)
                .extract().as(SuitesResponse.class);

        assertThat(suitesResponse.data().stream().map(project ->
                project.attributes().title()).toList()).contains(title);

        // get suite id
        final String suiteId = suitesResponse.data().stream()
                .filter(suite -> title.equals(suite.attributes().title()))
                .map(SuitesResponse.SuiteData::id).findFirst().orElseThrow();

        // delete suite
        suitesController
                .deleteSuiteForProject(AUTOMOTIVE, suiteId, jwtToken)
                .then().statusCode(200);
    }

    private SuiteRequest suiteRequest(final String title) {
        return new SuiteRequest()
                .data(new SuiteRequest.SuiteData()
                        .type("suites")
                        .attributes(new SuiteRequest.Attributes()
                                .title(title)));
    }

}