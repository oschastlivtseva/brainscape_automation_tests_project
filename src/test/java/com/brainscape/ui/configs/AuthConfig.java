package com.brainscape.ui.configs;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:ui/auth.properties"
})

public interface AuthConfig extends Config {

    @Key("testUserEmail")
    String getTestUserEmail();

    @Key("testUserPassword")
    String getTestUserPassword();

    @Key("testUserNameAndSurname")
    String getTestUserNameAndSurname();
}
