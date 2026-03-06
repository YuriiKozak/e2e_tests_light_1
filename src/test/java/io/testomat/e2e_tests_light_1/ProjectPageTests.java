package io.testomat.e2e_tests_light_1;

import io.testomat.e2e_tests_light_1.web.pages.ProjectPage;
import io.testomat.e2e_tests_light_1.web.pages.ProjectsPage;
import io.testomat.e2e_tests_light_1.web.pages.SignInPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ProjectPageTests extends BaseTest {

    private static final String email = cfg.email();
    private static final String password = cfg.password();

    private static final SignInPage signInPage = new SignInPage();
    private static final ProjectsPage projectsPage = new ProjectsPage();
    private static final ProjectPage projectPage = new ProjectPage();

    @BeforeAll
    public static void openSignInPage() {
        signInPage.open();
        signInPage.loginUser(email, password);
        projectsPage.signInSuccess();
    }

    @BeforeEach
    public void openProjectPage() {
        projectsPage.open();
        projectsPage.isLoaded();
    }

    @ParameterizedTest
    @CsvSource({
            "Automotive, 1",
            "Industrial, 2"
    })
    public void test(final String text, final int count) {
        projectsPage.searchProject(text);
        assertThat(projectsPage.getListOfProjects()).hasSize(count);
        projectsPage.selectProject(text);
        projectPage.isLoaded(text);
    }

}