package com.brainscape.mobile.drivers;

import com.brainscape.mobile.configs.AuthUserConfig;
import org.aeonbits.owner.ConfigFactory;

public class AuthUserDriver {
    public String getUserEmail() {
        AuthUserConfig config = ConfigFactory.create(AuthUserConfig.class);

        return config.getUserEmail();
    }

    public String getUserPassword() {
        AuthUserConfig config = ConfigFactory.create(AuthUserConfig.class);

        return config.getUserPassword();
    }

    public String getUserName() {
        AuthUserConfig config = ConfigFactory.create(AuthUserConfig.class);

        return config.getUserName();
    }
}