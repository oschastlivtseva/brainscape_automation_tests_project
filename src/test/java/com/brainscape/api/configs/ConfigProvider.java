package com.brainscape.api.configs;

import org.aeonbits.owner.ConfigFactory;

public class ConfigProvider {
    public static String getBaseURI() {
        APIConfig config = ConfigFactory.create(APIConfig.class);

        return config.getBaseURI();
    }

    public static String getBasePath() {
        APIConfig config = ConfigFactory.create(APIConfig.class);

        return config.getBasePath();
    }

    public static String getUserEmail() {
        AuthConfig config = ConfigFactory.create(AuthConfig.class);

        return config.getUserEmail();
    }

    public static String getUserPassword() {
        AuthConfig config = ConfigFactory.create(AuthConfig.class);

        return config.getUserPassword();
    }

    public static String getUserName() {
        UserDataConfig config = ConfigFactory.create(UserDataConfig.class);

        return config.getUserName();
    }

    public static String getUserLastName() {
        UserDataConfig config = ConfigFactory.create(UserDataConfig.class);

        return config.getUserLastName();
    }

    public static Integer getUserId() {
        UserDataConfig config = ConfigFactory.create(UserDataConfig.class);

        return config.getUserId();
    }

    public static Integer getProfileId() {
        UserDataConfig config = ConfigFactory.create(UserDataConfig.class);

        return config.getProfileId();
    }
}