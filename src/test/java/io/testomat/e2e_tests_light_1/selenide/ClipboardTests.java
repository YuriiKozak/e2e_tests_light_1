package io.testomat.e2e_tests_light_1.selenide;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.ClipboardConditions.content;
import static com.codeborne.selenide.Selenide.clipboard;

public class ClipboardTests extends BaseTest {

    @Test
    @DisplayName("Test: Clipboard")
    public void clipboardTest() {
        clipboard().setText(AUTOMOTIVE_PROJECT_NAME);
        clipboard().shouldHave(content(AUTOMOTIVE_PROJECT_NAME));
    }

}