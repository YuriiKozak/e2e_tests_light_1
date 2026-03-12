package io.testomat.e2e_tests_light_1.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(fluent = true)
public class SuitesResponse {

    private List<SuiteData> data;
    private Meta meta;

    @Data
    @Accessors(fluent = true)
    public static class SuiteData {
        private String id;
        private String type;
        private Attributes attributes;
        private Relationships relationships;
    }

    @Data
    @Accessors(fluent = true)
    public static class Attributes {
        private List<String> labels;
        private List<String> tags;
        private Object issues;

        @JsonProperty("jira-issues")
        private Object jiraIssues;

        @JsonProperty("is-branched")
        private boolean isBranched;

        @JsonProperty("is-detail")
        private boolean isDetail;

        private Object attachments;

        @JsonProperty("is-linked")
        private boolean isLinked;

        @JsonProperty("is-shared")
        private boolean isShared;

        private String title;
        private String emoji;
        private boolean sync;

        @JsonProperty("file-type")
        private String fileType;

        @JsonProperty("test-count")
        private int testCount;

        @JsonProperty("filtered-tests")
        private Object filteredTests;

        private String file;
        private String notes;

        @JsonProperty("created-at")
        private String createdAt;

        @JsonProperty("updated-at")
        private String updatedAt;

        @JsonProperty("assigned-to")
        private String assignedTo;

        @JsonProperty("to-url")
        private String toUrl;

        @JsonProperty("comments-count")
        private int commentsCount;

        private int position;
        private int depth;

        @JsonProperty("is-root")
        private boolean isRoot;

        @JsonProperty("public-title")
        private String publicTitle;

        @JsonProperty("parent-id")
        private String parentId;

        private String path;
    }

    @Data
    @Accessors(fluent = true)
    public static class Relationships {
        private Branch branch;
    }

    @Data
    @Accessors(fluent = true)
    public static class Branch {
        private Object data;
    }

    @Data
    @Accessors(fluent = true)
    public static class Meta {
        @JsonProperty("total_pages")
        private int totalPages;

        @JsonProperty("per_page")
        private int perPage;

        private int num;
        private int page;

        @JsonProperty("rId")
        private String rId;
    }

}