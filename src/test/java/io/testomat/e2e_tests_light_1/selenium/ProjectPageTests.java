package io.testomat.e2e_tests_light_1.selenium;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.testomat.e2e_tests_light_1.selenium.web.common.Elements.find;
import static io.testomat.e2e_tests_light_1.selenium.web.common.Elements.findByText;

public class ProjectPageTests extends BaseTest {

    @ParameterizedTest(name = "Scenario {index}: Find projects by name: \"{0}\"")
    @CsvSource({
            "'Books, Electronics & Kids'",
            "'Grocery, Outdoors & Shoes'",
            "'Industrial, Movies & Tools'"
    })
    @DisplayName("Test: Search And Select Project")
    public void searchAndSelectProjectTest(final String text) {
        find("#search").sendKeys(text);
        findByText(text).click();
        find(".first").waitFor().hasText(text);
    }

}