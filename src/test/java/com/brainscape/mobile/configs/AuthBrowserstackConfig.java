package com.brainscape.mobile.configs;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:mobile/properties/auth_browserstack.properties"
})

public interface AuthBrowserstackConfig extends Config {

    @Key("browserstack.user")
    String getBrowserstackUser();

    @Key("browserstack.key")
    String getBrowserstackKey();

}
