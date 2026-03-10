package io.testomat.e2e_tests_light_1.playwright;

import com.microsoft.playwright.Page;
import io.testomat.e2e_tests_light_1.playwright.common.PlayWrightExtension;
import io.testomat.e2e_tests_light_1.playwright.web.pages.LoginPage;
import io.testomat.e2e_tests_light_1.playwright.web.pages.ProjectsPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.RegisterExtension;

import static io.testomat.e2e_tests_light_1.utils.EnvConfig.EMAIL;
import static io.testomat.e2e_tests_light_1.utils.EnvConfig.PASSWORD;

public abstract class BaseTest {

    @RegisterExtension
    private static final PlayWrightExtension pw = new PlayWrightExtension();
    protected static Page page;

    @BeforeAll
    public static void openSignInPageAndSignIn() {
        page = pw.getPage();
        new LoginPage(page).open().loginUser(EMAIL, PASSWORD);
        new ProjectsPage(page).signInSuccess();
    }

}