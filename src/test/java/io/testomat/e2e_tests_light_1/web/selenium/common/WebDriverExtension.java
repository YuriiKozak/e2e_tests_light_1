package io.testomat.e2e_tests_light_1.web.selenium.common;

import org.jspecify.annotations.NonNull;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static io.testomat.e2e_tests_light_1.web.selenium.web.common.WebDriverProvider.driver;
import static io.testomat.e2e_tests_light_1.web.selenium.web.common.WebDriverProvider.quit;

public class WebDriverExtension implements BeforeAllCallback, AfterAllCallback {

    @Override
    public void beforeAll(final @NonNull ExtensionContext context) {
        driver();
        driver().manage().window().maximize();
    }

    @Override
    public void afterAll(final @NonNull ExtensionContext context) {
        quit();
    }

}