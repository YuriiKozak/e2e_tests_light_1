package io.testomat.e2e_tests_light_1.web.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class ProjectPage {

    public void isLoaded(final String text) {
        $(".first").shouldHave(Condition.text(text));
    }

}
