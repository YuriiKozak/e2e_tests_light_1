package io.testomat.e2e_tests_light.web.selenium.web.common;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Pattern;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.textMatches;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Waits {

    private final By selector;
    private final WebDriverWait wait;

    public Waits(final By selector) {
        this.selector = selector;
        this.wait = new WebDriverWait(WebDriverProvider.driver(), Duration.ofSeconds(7));
        this.wait.pollingEvery(Duration.ofSeconds(1));
    }

    public void isVisible() {
        this.wait.until(visibilityOfElementLocated(this.selector));
    }

    public void isHidden() {
        this.wait.until(invisibilityOfElementLocated(this.selector));
    }

    public void hasText(final String text) {
        this.wait.until(textMatches(this.selector, Pattern.compile(Pattern.quote(text), Pattern.CASE_INSENSITIVE)));
    }

}