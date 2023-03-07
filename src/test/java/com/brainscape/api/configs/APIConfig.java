package com.brainscape.api.configs;

import org.aeonbits.owner.Config;

public interface APIConfig extends Config {

    @Key("baseURI")
    @DefaultValue("https://www.brainscape.com/")
    String getBaseURI();

    @Key("basePath")
    @DefaultValue("api/")
    String getBasePath();

}