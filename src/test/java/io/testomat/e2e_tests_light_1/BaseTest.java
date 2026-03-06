package io.testomat.e2e_tests_light_1;

import com.codeborne.selenide.Configuration;
import io.testomat.e2e_tests_light_1.common.Application;
import io.testomat.e2e_tests_light_1.utils.EnvConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest {

    protected static final EnvConfig cfg = ConfigFactory.create(EnvConfig.class);
    protected static final String EMAIL = cfg.email();
    protected static final String PASSWORD = cfg.password();

    protected static final Application app = new Application();

    static {
        Configuration.baseUrl = cfg.url();
        Configuration.headless = false;
    }

    @BeforeAll
    public static void openSignInPageAndSignIn() {
        app.signInPage.open().loginUser(EMAIL, PASSWORD);
        app.projectsPage.signInSuccess();
    }

}