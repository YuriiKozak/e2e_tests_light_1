package io.testomat.e2e_tests_light_1.web.playwright;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import io.testomat.e2e_tests_light_1.web.playwright.common.PlayWrightApplication;
import io.testomat.e2e_tests_light_1.web.playwright.common.PlayWrightOptions;
import org.junit.jupiter.api.BeforeEach;

import static io.testomat.e2e_tests_light_1.utils.EnvConfig.EMAIL;
import static io.testomat.e2e_tests_light_1.utils.EnvConfig.PASSWORD;

@UsePlaywright(PlayWrightOptions.class)
public abstract class BaseTest {

    protected static PlayWrightApplication app;

    @BeforeEach
    public void openSignInPageAndSignIn(final Page page) {
        app = new PlayWrightApplication(page);
        app.loginPage.open().loginUser(EMAIL, PASSWORD);
        app.projectsPage.signInSuccess();
    }

}