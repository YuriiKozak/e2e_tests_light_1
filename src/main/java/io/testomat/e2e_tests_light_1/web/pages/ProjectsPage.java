package io.testomat.e2e_tests_light_1.web.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.jspecify.annotations.NonNull;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProjectsPage {

    public void open() {
        Selenide.open("");
    }

    public void searchProject(final String text) {
        $("#search").setValue(text);
    }

    public void selectProject(final String text) {
        $(Selectors.byText(text)).click();
    }

    public @NonNull List<SelenideElement> getListOfProjects() {
        return $$("#grid .relative").filter(visible).stream().toList();
    }

    public void isLoaded() {
        $("#search").shouldBe(visible);
    }

    public void signInSuccess() {
        $("#container .common-flash-success").shouldBe(visible);
    }

}
