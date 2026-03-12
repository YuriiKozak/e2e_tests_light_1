package io.testomat.e2e_tests_light_1.api;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.StreamReadFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;

import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;

public abstract class BaseTest {

    static {
        RestAssured.config = RestAssuredConfig.config()
                .objectMapperConfig(objectMapperConfig()
                        .jackson2ObjectMapperFactory((_, _) ->
                                new ObjectMapper().findAndRegisterModules()
                                        .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
                                        .configure(StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION.mappedFeature(), true)));
    }

    protected static final String AUTOMOTIVE = "Automotive";

}