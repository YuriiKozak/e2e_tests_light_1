package io.testomat.e2e_tests_light_1.web.selenium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ProjectPageTests extends BaseTest {

    @BeforeEach
    public void openProjectPage() {
        app.projectsPage.open().isLoaded();
    }

    @ParameterizedTest(name = "Scenario {index}: Find projects by name: {0}")
    @CsvSource({
            "'Books, Electronics & Kids'",
            "'Grocery, Outdoors & Shoes'",
            "'Industrial, Movies & Tools'"
    })
    @DisplayName("Test: Search And Select Project")
    public void searchAndSelectProjectTest(final String text) {
        app.projectsPage
                .searchProject(text)
                .selectProject(text);
        app.projectPage.isLoaded(text);
    }

}