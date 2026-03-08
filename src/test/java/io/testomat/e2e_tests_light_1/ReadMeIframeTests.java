package io.testomat.e2e_tests_light_1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ReadMeIframeTests extends BaseTest {

    @Test
    @DisplayName("Update ReadMe Text In Iframe")
    public void updateReadMeTextInIframeTest() {
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