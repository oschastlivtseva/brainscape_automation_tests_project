package com.brainscape.api.configs;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:api/auth.properties"
})

public interface AuthConfig extends Config {

    @Key("userEmail")
    String getUserEmail();

    @Key("userPassword")
    String getUserPassword();

}