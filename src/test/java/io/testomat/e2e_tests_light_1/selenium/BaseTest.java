package io.testomat.e2e_tests_light_1.selenium;

import io.testomat.e2e_tests_light_1.selenium.common.OpenProjectsPageExtension;
import io.testomat.e2e_tests_light_1.selenium.common.OpenSignInPageExtension;
import io.testomat.e2e_tests_light_1.selenium.common.WebDriverExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({OpenSignInPageExtension.class, OpenProjectsPageExtension.class, WebDriverExtension.class})
public abstract class BaseTest {

}