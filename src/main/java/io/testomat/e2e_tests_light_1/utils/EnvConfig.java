package io.testomat.e2e_tests_light_1.utils;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.Sources({"file:.env"})
public interface EnvConfig extends Config {

    @Key("URL")
    String url();

    @Key("EMAIL")
    String email();

    @Key("PASSWORD")
    String password();

    EnvConfig CFG = ConfigFactory.create(EnvConfig.class);
    String URL = CFG.url();
    String EMAIL = CFG.email();
    String PASSWORD = CFG.password();

}