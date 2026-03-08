package io.testomat.e2e_tests_light_1.web.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class ReadMePage {

    public ReadMePage clickOnEditReadme() {
        $(byText("Edit Readme")).click();
        return this;
    }

    public ReadMePage editFirstLineInEditor(final String text) {
        switchTo().frame($("#modal-overlays iframe[src='/ember-monaco/frame.html']"));
        $("textarea").setValue(text);
        return this;
    }

    public ReadMePage clickOnUpdate() {
        switchTo().defaultContent();
        $(byText("Update")).click();
        return this;
    }

    public ReadMePage clickOnCancel() {
        switchTo().defaultContent();
        $(byText("Cancel")).click();
        return this;
    }

    public ReadMePage isLoaded() {
        $(".setting-header").shouldHave(text("Readme"));
        return this;
    }

}