package io.testomat.e2e_tests_light_1.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.TextReportExtension;
import io.testomat.e2e_tests_light_1.selenide.common.Application;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.testomat.e2e_tests_light_1.utils.EnvConfig.EMAIL;
import static io.testomat.e2e_tests_light_1.utils.EnvConfig.PASSWORD;
import static io.testomat.e2e_tests_light_1.utils.EnvConfig.URL;

@ExtendWith(TextReportExtension.class)
public abstract class BaseTest {

    protected static final Application app = new Application();
    protected static final String AUTOMOTIVE_PROJECT_NAME = "Automotive";

    static {
        Configuration.baseUrl = URL;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.timeout = 7_000;
        Configuration.pollingInterval = 1_000;
    }

    @BeforeAll
    public static void openSignInPageAndSignIn() {
        app.loginPage.open().loginUser(EMAIL, PASSWORD);
        app.projectsPage.signInSuccess();
    }

}