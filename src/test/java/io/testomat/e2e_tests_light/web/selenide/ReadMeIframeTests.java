package io.testomat.e2e_tests_light.web.selenide;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ReadMeIframeTests extends BaseTest {

    @Test
    @DisplayName("Test: Update ReadMe Text In Iframe")
    public void updateReadMeTextInIframeTest() {
        app.projectsPage
                .isLoaded()
                .searchProject(AUTOMOTIVE)
                .selectProject(AUTOMOTIVE);

        app.projectPage
                .isLoaded(AUTOMOTIVE)
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