package io.testomat.e2e_tests_light_1.playwright.common;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.jspecify.annotations.NonNull;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class PlayWrightExtension implements BeforeAllCallback, AfterAllCallback {

    private Playwright playwright;
    private Browser browser;
    private static Page page;

    public Page getPage() {
        return page;
    }

    @Override
    public void beforeAll(final @NonNull ExtensionContext context) {
        playwright = Playwright.create();
        final BrowserType browserType = playwright.chromium();
        browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    @Override
    public void afterAll(final @NonNull ExtensionContext context) {
        page.close();
        browser.close();
        playwright.close();
    }

}