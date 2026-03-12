package io.testomat.e2e_tests_light_1.api.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
public class SuiteRequest {

    private SuiteData data;

    @Data
    @Accessors(fluent = true)
    public static class SuiteData {
        private String type;
        private Attributes attributes;
    }

    @Data
    @Accessors(fluent = true)
    public static class Attributes {
        private String title;
        private String description;
    }

}