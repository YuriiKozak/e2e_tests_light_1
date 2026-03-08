package io.testomat.e2e_tests_light_1;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.codeborne.selenide.ClipboardConditions.content;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.LocalStorageConditions.itemWithValue;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.clipboard;
import static com.codeborne.selenide.Selenide.localStorage;
import static org.assertj.core.api.Assertions.assertThat;

public class CollectionOfElementsTests extends BaseTest {

    @Test
    @DisplayName("Find All Products")
    public void findAllProductsTest() {
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

    @Test
    @DisplayName("Clipboard")
    public void clipboardTest() {
        clipboard().setText(AUTOMOTIVE_PROJECT_NAME);
        clipboard().shouldHave(content(AUTOMOTIVE_PROJECT_NAME));
    }

    @Test
    @DisplayName("Local Storage")
    public void localStorageTest() {
        localStorage().setItem(EMAIL, PASSWORD);

        final String currentTheme = localStorage().getItem(EMAIL);
        assertThat(currentTheme).isNotNull();

        localStorage().shouldHave(itemWithValue(EMAIL, currentTheme));

        localStorage().removeItem(EMAIL);
        localStorage().clear();
    }

}
