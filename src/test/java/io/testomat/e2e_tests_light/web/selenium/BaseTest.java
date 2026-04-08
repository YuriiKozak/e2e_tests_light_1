package io.testomat.e2e_tests_light.web.selenium;

import io.testomat.e2e_tests_light.web.selenium.common.Application;
import io.testomat.e2e_tests_light.web.selenium.common.WebDriverExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.testomat.e2e_tests_light.utils.EnvConfig.EMAIL;
import static io.testomat.e2e_tests_light.utils.EnvConfig.PASSWORD;

@ExtendWith(WebDriverExtension.class)
public abstract class BaseTest {

    protected static final Application app = new Application();

    @BeforeAll
    public static void openSignInPageAndSignIn() {
        app.loginPage.open().loginUser(EMAIL, PASSWORD);
        app.projectsPage.signInSuccess();
    }

}