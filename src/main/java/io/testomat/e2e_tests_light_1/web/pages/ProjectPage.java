package io.testomat.e2e_tests_light_1.web.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;

public class ProjectPage {

    public ProjectPage openMenu() {
        $(".md-icon-dots-horizontal").click();
        return this;
    }

    public ProjectPage openReadme() {
        $(byLinkText("Readme")).click();
        return this;
    }

    public ProjectPage editReadme() {
        $(byLinkText("Edit")).click();
        return this;
    }

    public ProjectPage isLoaded(final String text) {
        $(".first").shouldHave(text(text));
        return this;
    }

}