package io.testomat.e2e_tests_light_1.selenium.web.pages;

import static io.testomat.e2e_tests_light_1.selenium.web.common.Elements.find;
import static io.testomat.e2e_tests_light_1.selenium.web.common.WebDriverProvider.driver;
import static io.testomat.e2e_tests_light_1.utils.EnvConfig.URL;

public class LoginPage {

    public LoginPage open() {
        driver().get(URL);
        return this;
    }

    public void loginUser(final String email, final String password) {
        find("#content-desktop #user_email").sendKeys(email);
        find("#content-desktop #user_password").sendKeys(password);
        find("#content-desktop #user_remember_me").click();
        find("#content-desktop [name=\"commit\"]").click();
        find("#content-desktop #user_email").waitFor().isHidden();
        find("#content-desktop #user_password").waitFor().isHidden();
    }

}