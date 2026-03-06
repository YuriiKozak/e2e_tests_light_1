package io.testomat.e2e_tests_light_1.utils;

import org.aeonbits.owner.Config;

@Config.Sources({"file:.env"})
public interface Configuration extends Config {

    @Key("URL")
    String url();

    @Key("EMAIL")
    String email();

    @Key("PASSWORD")
    String password();

}