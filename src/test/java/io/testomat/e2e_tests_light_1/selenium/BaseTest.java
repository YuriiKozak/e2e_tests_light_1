package io.testomat.e2e_tests_light_1.selenium;

import io.testomat.e2e_tests_light_1.selenium.common.Application;
import io.testomat.e2e_tests_light_1.selenium.common.WebDriverExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.testomat.e2e_tests_light_1.utils.EnvConfig.EMAIL;
import static io.testomat.e2e_tests_light_1.utils.EnvConfig.PASSWORD;

@ExtendWith(WebDriverExtension.class)
public abstract class BaseTest {

    protected static final Application app = new Application();

    @BeforeAll
    public static void openSignInPageAndSignIn() {
        app.loginPage.open().loginUser(EMAIL, PASSWORD);
        app.projectsPage.signInSuccess();
    }

}