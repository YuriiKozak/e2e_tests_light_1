package io.testomat.e2e_tests_light.web.selenide;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$$;

public class ProjectsPageTests extends BaseTest {

    @Test
    @DisplayName("Test: Find All Projects")
    public void findAllProjectsTest() {
        final List<String> expectedTests = List.of("2 tests", "3 tests", "0 tests",
                "0 tests", "0 tests", "0 tests", "0 tests", "0 tests", "0 tests", "0 tests",
                "0 tests", "0 tests", "0 tests", "0 tests", "0 tests", "0 tests", "0 tests",
                "0 tests", "0 tests", "0 tests", "1 tests", "0 tests", "0 tests", "0 tests");

        final ElementsCollection actualTexts = $$("ul li p");
        actualTexts
                .shouldHave(sizeGreaterThan(0))
                .shouldHave(texts(expectedTests));

        for (SelenideElement actualText : actualTexts) {
            actualText
                    .shouldHave(text("0 tests")
                            .or(text("1 tests"))
                            .or(text("2 tests"))
                            .or(text("3 tests")));
        }

        $$(byText("0 tests")).shouldHave(size(21));
        $$(byText("1 tests")).shouldHave(size(1));
        $$(byText("2 tests")).shouldHave(size(1));
        $$(byText("3 tests")).shouldHave(size(1));
        $$(byText("4 tests")).shouldHave(size(0));
    }

}