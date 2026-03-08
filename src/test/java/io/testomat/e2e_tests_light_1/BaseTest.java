package io.testomat.e2e_tests_light_1;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.TextReportExtension;
import io.testomat.e2e_tests_light_1.common.Application;
import io.testomat.e2e_tests_light_1.utils.EnvConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({TextReportExtension.class})
public abstract class BaseTest {

    protected static final EnvConfig cfg = ConfigFactory.create(EnvConfig.class);
    protected static final String EMAIL = cfg.email();
    protected static final String PASSWORD = cfg.password();

    protected static final Application app = new Application();
    protected static final String AUTOMOTIVE_PROJECT_NAME = "Automotive";

    static {
        Configuration.baseUrl = cfg.url();
        Configuration.headless = false;
        Configuration.timeout = 7_000;
    }

    @BeforeAll
    public static void openSignInPageAndSignIn() {
        app.signInPage.open().loginUser(EMAIL, PASSWORD);
        app.projectsPage.signInSuccess();
    }

}