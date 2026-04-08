package io.testomat.e2e_tests_light.web.playwright.web.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPage {

    private final Page page;
    private final Locator desktopContainer;

    public LoginPage(final Page page) {
        this.page = page;
        this.desktopContainer = page.locator("#content-desktop");
    }

    public LoginPage open() {
        page.navigate("");
        return this;
    }

    public LoginPage loginUser(final String email, final String password) {
        desktopContainer.locator("#user_email").fill(email);
        desktopContainer.locator("#user_password").fill(password);

        desktopContainer.locator("#user_remember_me").click();
        desktopContainer.locator("[name='commit']").click();

        assertThat(desktopContainer.locator("#user_email")).isHidden();
        assertThat(desktopContainer.locator("#user_password")).isHidden();

        return this;
    }

}