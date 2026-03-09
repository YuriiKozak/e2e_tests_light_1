package io.testomat.e2e_tests_light_1.selenium;

import io.testomat.e2e_tests_light_1.selenium.common.OpenProjectsPageExtension;
import io.testomat.e2e_tests_light_1.selenium.common.OpenSignInPageAndSignInExtension;
import io.testomat.e2e_tests_light_1.selenium.common.WebDriverLifecycleExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({
        OpenSignInPageAndSignInExtension.class,
        OpenProjectsPageExtension.class,
        WebDriverLifecycleExtension.class
})
public abstract class BaseTest {

}