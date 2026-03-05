package io.testomat.e2e_tests_light_1;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProjectPageTest {

    @Test
    public void firstTest() {
        open("https://app.testomat.io/");

        // login user
        $("#content-desktop #user_email").setValue("yura.kozak.de@gmail.com");
        $("#content-desktop #user_password").setValue("YNWLpn4pZRERa!5");
        $("#content-desktop #user_remember_me").click();
        $("#content-desktop [name=\"commit\"]").click();
        $(".common-flash-success-right").shouldBe(Condition.visible);

        // search project
        $("#search").setValue("Automotive");

        // select project
        $(Selectors.byText("Automotive")).click();

        // wait for page is loaded
        $(".first").shouldHave(Condition.text("Automotive"));
    }

}