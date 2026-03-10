package io.testomat.e2e_tests_light_1.selenium.common;

import org.jspecify.annotations.NonNull;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static io.testomat.e2e_tests_light_1.selenium.web.common.Elements.find;
import static io.testomat.e2e_tests_light_1.selenium.web.common.WebDriverProvider.driver;
import static io.testomat.e2e_tests_light_1.utils.EnvConfig.URL;

public class OpenProjectsPageExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(final @NonNull ExtensionContext context) {
        driver().get(URL);
        find("#search").waitFor().isVisible();
    }

}