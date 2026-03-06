package io.testomat.e2e_tests_light_1;

import com.codeborne.selenide.junit5.TextReportExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({TextReportExtension.class})
public class ReadMeIframeTest extends BaseTest {

    private static final String AUTOMOTIVE_PROJECT_NAME = "Automotive";

    @Test
    @DisplayName("Update ReadMe Text In Iframe")
    public void updateReadMeTextInIframe() {
        app.projectsPage
                .isLoaded()
                .searchProject(AUTOMOTIVE_PROJECT_NAME)
                .selectProject(AUTOMOTIVE_PROJECT_NAME);

        app.projectPage
                .isLoaded(AUTOMOTIVE_PROJECT_NAME)
                .openMenu()
                .openReadme()
                .editReadme();

        app.readMePage
                .isLoaded()
                .clickOnEditReadme()
                .editFirstLineInEditor("SOME NEW TEXT")
                .clickOnCancel();
    }

}