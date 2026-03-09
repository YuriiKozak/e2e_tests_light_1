package io.testomat.e2e_tests_light_1.selenium.common;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static io.testomat.e2e_tests_light_1.selenium.web.common.WebDriverProvider.driver;
import static io.testomat.e2e_tests_light_1.selenium.web.common.WebDriverProvider.quit;

public class WebDriverLifecycleExtension implements BeforeAllCallback, AfterAllCallback {

    @Override
    public void beforeAll(final ExtensionContext context) {
        driver();
        driver().manage().window().maximize();
    }

    @Override
    public void afterAll(final ExtensionContext context) {
        quit();
    }

}