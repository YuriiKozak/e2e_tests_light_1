package io.testomat.e2e_tests_light_1.selenium.common;

import io.testomat.e2e_tests_light_1.selenium.web.pages.LoginPage;
import org.jspecify.annotations.NonNull;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static io.testomat.e2e_tests_light_1.selenium.web.common.Elements.find;
import static io.testomat.e2e_tests_light_1.selenium.web.common.WebDriverProvider.driver;
import static io.testomat.e2e_tests_light_1.utils.EnvConfig.EMAIL;
import static io.testomat.e2e_tests_light_1.utils.EnvConfig.PASSWORD;
import static io.testomat.e2e_tests_light_1.utils.EnvConfig.URL;

public class OpenSignInPageExtension implements BeforeAllCallback {

    @Override
    public void beforeAll(final @NonNull ExtensionContext context) {
        driver().get(URL);
        new LoginPage().login(EMAIL, PASSWORD);
        find("#container .common-flash-success").waitFor().isVisible();
    }

}