package io.testomat.e2e_tests_light.web.selenide;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static com.codeborne.selenide.LocalStorageConditions.itemWithValue;
import static com.codeborne.selenide.Selenide.localStorage;
import static io.testomat.e2e_tests_light.utils.EnvConfig.EMAIL;
import static io.testomat.e2e_tests_light.utils.EnvConfig.PASSWORD;

public class LocalStorageTests extends BaseTest {

    @Test
    @DisplayName("Test: Local Storage")
    public void localStorageTest() {
        localStorage().setItem(EMAIL, PASSWORD);
        localStorage().shouldHave(itemWithValue(EMAIL, Objects.requireNonNull(localStorage().getItem(EMAIL))));
        localStorage().removeItem(EMAIL);
        localStorage().clear();
    }

}