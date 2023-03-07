package com.brainscape.ui.configs;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:ui/${env}.properties"
})

public interface WebConfig extends Config {

    @Key("env")
    String getEnv();

    @Key("baseURL")
    String getBaseURL();

    @Key("browser")
    String getBrowser();

    @Key("remoteURL")
    String getRemoteURL();

    @Key("browserSize")
    String getBrowserSize();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("timeout")
    Long getTimeout();

}
