package com.brainscape.api.configs;

import org.aeonbits.owner.Config;

public interface UserDataConfig extends Config {

    @Key("userName")
    @DefaultValue("Quinn")
    String getUserName();

    @Key("userLastName")
    @DefaultValue("Mayert")
    String getUserLastName();

    @Key("userId")
    @DefaultValue("8324233")
    Integer getUserId();

    @Key("profileId")
    @DefaultValue("8323260")
    Integer getProfileId();

}
