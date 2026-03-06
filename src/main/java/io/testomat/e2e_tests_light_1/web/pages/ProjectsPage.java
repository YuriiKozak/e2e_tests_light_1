package io.testomat.e2e_tests_light_1.web.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.jspecify.annotations.NonNull;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProjectsPage {

    public ProjectsPage open() {
        Selenide.open("");
        return this;
    }

    public ProjectsPage searchProject(final String text) {
        $("#search").setValue(text);
        return this;
    }

    public ProjectsPage selectProject(final String text) {
        $(byText(text)).click();
        return this;
    }

    public @NonNull List<SelenideElement> getListOfProjects() {
        return $$("#grid .relative").filter(visible).stream().toList();
    }

    public ProjectsPage isLoaded() {
        $("#search").shouldBe(visible);
        return this;
    }

    public ProjectsPage signInSuccess() {
        $("#container .common-flash-success").shouldBe(visible);
        return this;
    }

}