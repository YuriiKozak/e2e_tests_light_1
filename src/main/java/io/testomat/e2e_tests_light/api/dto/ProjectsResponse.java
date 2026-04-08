package io.testomat.e2e_tests_light.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(fluent = true)
public class ProjectsResponse {

    private List<ProjectData> data;

    @Data
    @Accessors(fluent = true)
    public static class ProjectData {
        private String id;
        private String type;
        private ProjectAttributes attributes;
        private ProjectRelationships relationships;
    }

    @Data
    @Accessors(fluent = true)
    public static class ProjectAttributes {
        private Object attachments;
        private String title;
        private Object framework;
        private Object timezone;
        private String lang;
        private Object github;
        private String url;

        @JsonProperty("tests-count")
        private int testsCount;

        @JsonProperty("created-at")
        private String createdAt;

        private boolean demo;

        @JsonProperty("has-living-docs")
        private boolean hasLivingDocs;

        @JsonProperty("record-url")
        private String recordUrl;

        private Object avatar;

        @JsonProperty("jira-count")
        private Object jiraCount;

        private String status;

        @JsonProperty("api-key")
        private String apiKey;

        @JsonProperty("testomatio-url")
        private String testomatioUrl;

        private String branch;
        private Object jira;
        private Object company;

        @JsonProperty("company-slug")
        private String companySlug;

        private Object subscription;
        private Object features;

        @JsonProperty("import-progress")
        private Object importProgress;

        private Object environments;

        @JsonProperty("ci-settings")
        private Object ciSettings;

        @JsonProperty("issue-settings")
        private Object issueSettings;

        @JsonProperty("runs-settings")
        private Object runsSettings;

        @JsonProperty("manual-tag-settings")
        private Object manualTagSettings;

        @JsonProperty("automated-run-timeout")
        private Object automatedRunTimeout;

        @JsonProperty("run-replies")
        private Object runReplies;

        @JsonProperty("whitelist-ip")
        private String whitelistIp;

        @JsonProperty("aws-account-id")
        private String awsAccountId;

        @JsonProperty("versions-max-days")
        private int versionsMaxDays;

        @JsonProperty("artifacts-settings")
        private ArtifactsSettings artifactsSettings;

        @JsonProperty("living-doc-url")
        private String livingDocUrl;

        @JsonProperty("project-settings")
        private ProjectSettings projectSettings;

        @JsonProperty("company-settings")
        private CompanySettings companySettings;

        @JsonProperty("template-kinds")
        private List<String> templateKinds;
    }

    @Data
    @Accessors(fluent = true)
    public static class ArtifactsSettings {
        private boolean presign;
    }

    @Data
    @Accessors(fluent = true)
    public static class ProjectSettings {
        @JsonProperty("is_share_public_report")
        private boolean isSharePublicReport;

        @JsonProperty("is_share_living_docs")
        private boolean isShareLivingDocs;

        @JsonProperty("is_keep_ids_in_feature")
        private boolean isKeepIdsInFeature;

        @JsonProperty("is_shows_test_type")
        private boolean isShowsTestType;

        @JsonProperty("is_run_folder_required")
        private boolean isRunFolderRequired;

        @JsonProperty("is_restrict_suites_sharing")
        private boolean isRestrictSuitesSharing;

        @JsonProperty("hidden_prefixes")
        private List<HiddenPrefix> hiddenPrefixes;

        @JsonProperty("semantic_search")
        private boolean semanticSearch;

        @JsonProperty("similar_search")
        private boolean similarSearch;

        @JsonProperty("ai_chat")
        private boolean aiChat;

        @JsonProperty("trace_url")
        private String traceUrl;

        @JsonProperty("import_testrail")
        private boolean importTestrail;

        @JsonProperty("analytics_all_widgets")
        private List<String> analyticsAllWidgets;

        @JsonProperty("analytics_chosen_widgets")
        private List<String> analyticsChosenWidgets;

        @JsonProperty("ai_language")
        private String aiLanguage;

        @JsonProperty("labels_permission")
        private boolean labelsPermission;

        @JsonProperty("archive_storage")
        private boolean archiveStorage;
    }

    @Data
    @Accessors(fluent = true)
    public static class HiddenPrefix {
        private String value;
        private boolean regExp;
    }

    @Data
    @Accessors(fluent = true)
    public static class CompanySettings {
        @JsonProperty("is_share_public_report")
        private boolean isSharePublicReport;

        @JsonProperty("is_share_living_docs")
        private boolean isShareLivingDocs;

        @JsonProperty("ai_enabled")
        private boolean aiEnabled;

        @JsonProperty("ai_hidden")
        private boolean aiHidden;
    }

    @Data
    @Accessors(fluent = true)
    public static class ProjectRelationships {
        private Requirements requirements;
    }

    @Data
    @Accessors(fluent = true)
    public static class Requirements {
        private List<Object> data;
    }

}