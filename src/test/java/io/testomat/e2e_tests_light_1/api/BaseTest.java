package io.testomat.e2e_tests_light_1.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.testomat.e2e_tests_light_1.api.controller.LoginController;
import io.testomat.e2e_tests_light_1.api.controller.ProjectsController;
import io.testomat.e2e_tests_light_1.api.controller.SuitesController;
import org.junit.jupiter.api.BeforeAll;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;
import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;
import static io.restassured.config.RestAssuredConfig.config;
import static io.testomat.e2e_tests_light_1.utils.EnvConfig.EMAIL;
import static io.testomat.e2e_tests_light_1.utils.EnvConfig.PASSWORD;

public abstract class BaseTest {

    protected static final String AUTOMOTIVE = "Automotive";
    private static String jwtToken;

    static {
        RestAssured.config = config()
                .objectMapperConfig(objectMapperConfig()
                        .jackson2ObjectMapperFactory((_, _) ->
                                new ObjectMapper().findAndRegisterModules().setVisibility(FIELD, ANY)));
    }

    @BeforeAll
    static void loginUserAndGetJwtToken() {
        jwtToken = new LoginController()
                .loginUserAndGetJwtToken(EMAIL, PASSWORD)
                .then().statusCode(200)
                .extract().jsonPath().getString("jwt");
    }

    protected SuitesController suitesController = new SuitesController().withToken(jwtToken);
    protected ProjectsController projectsController = new ProjectsController().withToken(jwtToken);

}