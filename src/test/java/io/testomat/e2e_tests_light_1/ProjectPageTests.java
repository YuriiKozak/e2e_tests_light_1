package io.testomat.e2e_tests_light_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ProjectPageTests extends BaseTest {

    @BeforeEach
    public void openProjectPage() {
        app.projectsPage.open().isLoaded();
    }

    @ParameterizedTest
    @CsvSource({
            "Automotive, 1",
            "Industrial, 2"
    })
    public void test(final String text, final int count) {
        app.projectsPage.searchProject(text);
        assertThat(app.projectsPage.getListOfProjects()).hasSize(count);
        app.projectsPage.selectProject(text);
        app.projectPage.isLoaded(text);
    }

}