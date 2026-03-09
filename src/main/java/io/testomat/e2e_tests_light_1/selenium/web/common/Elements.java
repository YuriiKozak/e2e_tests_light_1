package io.testomat.e2e_tests_light_1.selenium.web.common;

import org.openqa.selenium.By;

public class Elements {

    public static ElementActions find(final String selector) {
        final By targetLocator = selector.startsWith("//") ? By.xpath(selector) : By.cssSelector(selector);
        return new ElementActions(targetLocator);
    }

    public static ElementActions findByText(final String text) {
        return new ElementActions(By.xpath("//*[text()='" + text + "']"));
    }

}