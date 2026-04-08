package io.testomat.e2e_tests_light.web.playwright.common;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.junit.Options;
import com.microsoft.playwright.junit.OptionsFactory;

import static io.testomat.e2e_tests_light.utils.EnvConfig.URL;

public class PlayWrightOptions implements OptionsFactory {

    @Override
    public Options getOptions() {
        return new Options()
                .setHeadless(false)
                .setBaseUrl(URL)
                .setContextOptions(new Browser.NewContextOptions().setViewportSize(1920, 1080))
                .setTrace(Options.Trace.ON);
    }

}