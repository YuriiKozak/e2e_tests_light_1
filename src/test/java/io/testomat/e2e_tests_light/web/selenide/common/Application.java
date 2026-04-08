package io.testomat.e2e_tests_light.web.selenide.common;

import io.testomat.e2e_tests_light.web.selenide.web.pages.LoginPage;
import io.testomat.e2e_tests_light.web.selenide.web.pages.ProjectPage;
import io.testomat.e2e_tests_light.web.selenide.web.pages.ProjectsPage;
import io.testomat.e2e_tests_light.web.selenide.web.pages.ReadMePage;

public class Application {

    public final LoginPage loginPage = new LoginPage();
    public final ProjectsPage projectsPage = new ProjectsPage();
    public final ProjectPage projectPage = new ProjectPage();
    public final ReadMePage readMePage = new ReadMePage();

}