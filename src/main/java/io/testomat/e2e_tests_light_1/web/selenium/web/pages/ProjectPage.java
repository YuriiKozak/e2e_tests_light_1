package io.testomat.e2e_tests_light_1.web.selenium.web.pages;

import static io.testomat.e2e_tests_light_1.web.selenium.web.common.Elements.find;
import static io.testomat.e2e_tests_light_1.web.selenium.web.common.Elements.findByText;

public class ProjectPage {

    public ProjectPage openMenu() {
        find(".md-icon-dots-horizontal").click();
        return this;
    }

    public ProjectPage openReadme() {
        findByText("Readme").click();
        return this;
    }

    public ProjectPage editReadme() {
        findByText("Edit").click();
        return this;
    }

    public ProjectPage isLoaded(final String text) {
        find(".first").waitFor().hasText(text);
        return this;
    }

}