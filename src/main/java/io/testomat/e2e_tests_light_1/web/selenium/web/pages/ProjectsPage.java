package io.testomat.e2e_tests_light_1.web.selenium.web.pages;

import static io.testomat.e2e_tests_light_1.utils.EnvConfig.URL;
import static io.testomat.e2e_tests_light_1.web.selenium.web.common.Elements.find;
import static io.testomat.e2e_tests_light_1.web.selenium.web.common.Elements.findByText;
import static io.testomat.e2e_tests_light_1.web.selenium.web.common.WebDriverProvider.driver;

public class ProjectsPage {

    public ProjectsPage open() {
        driver().get(URL);
        return this;
    }

    public ProjectsPage searchProject(final String text) {
        find("#search").sendKeys(text);
        return this;
    }

    public ProjectsPage selectProject(final String text) {
        findByText(text).click();
        return this;
    }

    public ProjectsPage isLoaded() {
        find("#search").waitFor().isVisible();
        return this;
    }

    public ProjectsPage signInSuccess() {
        find("#container .common-flash-success").waitFor().isVisible();
        return this;
    }

}