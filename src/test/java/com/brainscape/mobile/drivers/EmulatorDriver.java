package com.brainscape.mobile.drivers;

import com.brainscape.mobile.configs.EmulatorConfig;
import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import lombok.SneakyThrows;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobileBrowserType.ANDROID;

public class EmulatorDriver implements WebDriverProvider {

    @SneakyThrows
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        EmulatorConfig config = ConfigFactory.create(EmulatorConfig.class, System.getProperties());

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setDeviceName(config.getDeviceName())
                .setPlatformVersion(config.getPlatformVersion())
                .setApp(getAppPath())
                .setAppPackage(config.getAppPackage())
                .setAppActivity(config.getAppActivity());

        return new AndroidDriver(new URL(config.getAppiumServer()), options);
    }

    private String getAppPath() {
        EmulatorConfig config = ConfigFactory.create(EmulatorConfig.class, System.getProperties());

        String appPath = config.getAppPath();

        File app = new File(appPath);
        return app.getAbsolutePath();
    }

}
