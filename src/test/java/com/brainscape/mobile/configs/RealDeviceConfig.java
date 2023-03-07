package com.brainscape.mobile.configs;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:mobile/properties/real.properties"
})

public interface RealDeviceConfig extends Config {

    @Key("appiumServer")
    String getAppiumServer();

    @Key("deviceName")
    String getDeviceName();

    @Key("platformVersion")
    String getPlatformVersion();

    @Key("appPath")
    String getAppPath();

    @Key("appPackage")
    String getAppPackage();

    @Key("appActivity")
    String getAppActivity();

}
