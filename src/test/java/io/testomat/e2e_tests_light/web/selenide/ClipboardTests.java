package io.testomat.e2e_tests_light.web.selenide;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.ClipboardConditions.content;
import static com.codeborne.selenide.Selenide.clipboard;

public class ClipboardTests extends BaseTest {

    @Test
    @DisplayName("Test: Clipboard")
    public void clipboardTest() {
        clipboard().setText(AUTOMOTIVE);
        clipboard().shouldHave(content(AUTOMOTIVE));
    }

}