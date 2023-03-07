package com.brainscape.mobile.configs;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:mobile/properties/auth_user.properties"
})

public interface AuthUserConfig extends Config {

    @Key("user.email")
    String getUserEmail();

    @Key("user.password")
    String getUserPassword();

    @Key("user.name")
    String getUserName();

}
