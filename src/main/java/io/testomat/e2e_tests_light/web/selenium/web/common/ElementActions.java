package io.testomat.e2e_tests_light.web.selenium.web.common;

import org.openqa.selenium.By;

import static io.testomat.e2e_tests_light.web.selenium.web.common.WebDriverProvider.driver;

public class ElementActions {

    private final By selector;

    public ElementActions(final By selector) {
        this.selector = selector;
    }

    public void click() {
        waitFor().isVisible();
        driver().findElement(this.selector).click();
    }

    public void sendKeys(final String text) {
        waitFor().isVisible();
        driver().findElement(this.selector).sendKeys(text);
    }

    public Waits waitFor() {
        return new Waits(this.selector);
    }

}