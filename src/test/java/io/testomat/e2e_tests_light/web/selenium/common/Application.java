package io.testomat.e2e_tests_light.web.selenium.common;

import io.testomat.e2e_tests_light.web.selenium.web.pages.LoginPage;
import io.testomat.e2e_tests_light.web.selenium.web.pages.ProjectPage;
import io.testomat.e2e_tests_light.web.selenium.web.pages.ProjectsPage;

public class Application {

    public final LoginPage loginPage = new LoginPage();
    public final ProjectsPage projectsPage = new ProjectsPage();
    public final ProjectPage projectPage = new ProjectPage();

}