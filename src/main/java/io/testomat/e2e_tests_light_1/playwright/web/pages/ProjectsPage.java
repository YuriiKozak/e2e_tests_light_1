package io.testomat.e2e_tests_light_1.playwright.web.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static io.testomat.e2e_tests_light_1.utils.EnvConfig.URL;

public class ProjectsPage {

    private final Page page;
    private final Locator searchInput;
    private final Locator successFlash;

    public ProjectsPage(final Page page) {
        this.page = page;
        this.searchInput = page.locator("#search");
        this.successFlash = page.locator("#container .common-flash-success");
    }

    public ProjectsPage open() {
        page.navigate(URL);
        return this;
    }

    public ProjectsPage searchProject(final String text) {
        searchInput.fill(text);
        return this;
    }

    public ProjectsPage selectProject(final String text) {
        page.getByText(text, new Page.GetByTextOptions().setExact(true)).click();
        return this;
    }

    public ProjectsPage isLoaded() {
        assertThat(searchInput).isVisible();
        return this;
    }

    public ProjectsPage signInSuccess() {
        assertThat(successFlash).isVisible();
        return this;
    }

}