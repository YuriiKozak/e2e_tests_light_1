package io.testomat.e2e_tests_light_1.selenide;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.ClipboardConditions.content;
import static com.codeborne.selenide.LocalStorageConditions.itemWithValue;
import static com.codeborne.selenide.Selenide.clipboard;
import static com.codeborne.selenide.Selenide.localStorage;
import static io.testomat.e2e_tests_light_1.utils.EnvConfig.EMAIL;
import static io.testomat.e2e_tests_light_1.utils.EnvConfig.PASSWORD;
import static org.assertj.core.api.Assertions.assertThat;

public class ClipboardAndLocalStorageTests extends BaseTest {

    @Test
    @DisplayName("Test: Clipboard")
    public void clipboardTest() {
        clipboard().setText(AUTOMOTIVE_PROJECT_NAME);
        clipboard().shouldHave(content(AUTOMOTIVE_PROJECT_NAME));
    }

    @Test
    @DisplayName("Test: Local Storage")
    public void localStorageTest() {
        localStorage().setItem(EMAIL, PASSWORD);

        final String currentTheme = localStorage().getItem(EMAIL);
        assertThat(currentTheme).isNotNull();

        localStorage().shouldHave(itemWithValue(EMAIL, currentTheme));

        localStorage().removeItem(EMAIL);
        localStorage().clear();
    }

}