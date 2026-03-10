package io.testomat.e2e_tests_light_1.playwright.common;

import com.microsoft.playwright.Page;
import io.testomat.e2e_tests_light_1.playwright.web.pages.LoginPage;
import io.testomat.e2e_tests_light_1.playwright.web.pages.ProjectPage;
import io.testomat.e2e_tests_light_1.playwright.web.pages.ProjectsPage;

public class PlayWrightApplication {

    public final LoginPage loginPage;
    public final ProjectsPage projectsPage;
    public final ProjectPage projectPage;

    public PlayWrightApplication(final Page page) {
        loginPage = new LoginPage(page);
        projectsPage = new ProjectsPage(page);
        projectPage = new ProjectPage(page);
    }

}