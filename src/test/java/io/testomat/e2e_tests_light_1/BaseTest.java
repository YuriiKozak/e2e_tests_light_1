package io.testomat.e2e_tests_light_1;

import com.codeborne.selenide.Configuration;
import io.testomat.e2e_tests_light_1.utils.EnvConfig;
import org.aeonbits.owner.ConfigFactory;

public abstract class BaseTest {

    protected static final EnvConfig cfg = ConfigFactory.create(EnvConfig.class);

    static {
        Configuration.baseUrl = cfg.url();
    }

}