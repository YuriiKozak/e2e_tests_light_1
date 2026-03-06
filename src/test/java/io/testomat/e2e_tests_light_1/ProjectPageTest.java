package io.testomat.e2e_tests_light_1;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import org.jspecify.annotations.NonNull;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class ProjectPageTest extends BaseTest {

    private static final String url = cfg.url();
    private static final String email = cfg.email();
    private static final String password = cfg.password();

    @BeforeEach
    public void setUp() {
        open(url);
        loginUser(email, password);
    }

    @AfterEach
    public void tearDown() {
        clearBrowserCookies();
    }

    @ParameterizedTest
    @CsvSource({
            "Automotive, 1",
            "Industrial, 2"
    })
    public void test(final String text, final int count) {

        searchProject(text);
        assertThat(getListOfProjects()).hasSize(count);

        selectProject(text);
        waitForPageIsLoaded(text);
    }

    private static void loginUser(final String email, final String password) {
        $("#content-desktop #user_email").setValue(email);
        $("#content-desktop #user_password").setValue(password);
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop [name=\"commit\"]").click();
        $(".common-flash-success-right").shouldBe(visible);
    }

    private static @NonNull List<SelenideElement> getListOfProjects() {
        return $$("#grid .relative").filter(visible).stream().toList();
    }

    private static void searchProject(final String text) {
        $("#search").setValue(text);
    }

    private static void selectProject(final String text) {
        $(Selectors.byText(text)).click();
    }

    private static void waitForPageIsLoaded(final String text) {
        $(".first").shouldHave(Condition.text(text));
    }

}