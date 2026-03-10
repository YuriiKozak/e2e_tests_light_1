package io.testomat.e2e_tests_light_1.playwright.web.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProjectPage {

    private final Page page;

    public ProjectPage(final Page page) {
        this.page = page;
    }

    public ProjectPage openMenu() {
        page.locator(".md-icon-dots-horizontal").click();
        return this;
    }

    public ProjectPage openReadme() {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Readme")).click();
        return this;
    }

    public ProjectPage editReadme() {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Edit")).click();
        return this;
    }

    public ProjectPage isLoaded(final String text) {
        assertThat(page.locator(".first")).containsText(text);
        return this;
    }

}