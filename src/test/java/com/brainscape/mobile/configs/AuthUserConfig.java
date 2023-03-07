package com.brainscape.mobile.configs;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:mobile/properties/auth_user.properties"
})

public interface AuthUserConfig extends Config {

    @Key("userEmail")
    String getUserEmail();

    @Key("userPassword")
    String getUserPassword();

    @Key("userName")
    String getUserName();

}
