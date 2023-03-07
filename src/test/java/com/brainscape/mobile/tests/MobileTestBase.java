package com.brainscape.mobile.tests;

import com.brainscape.mobile.drivers.AuthUserDriver;
import com.brainscape.mobile.drivers.BrowserstackDriver;
import com.brainscape.mobile.drivers.EmulatorDriver;
import com.brainscape.mobile.drivers.RealDeviceDriver;
import com.brainscape.mobile.helpers.TestAttachment;
import com.brainscape.mobile.pages.AccountPage;
import com.brainscape.mobile.pages.LandingPage;
import com.brainscape.mobile.pages.LoginPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class MobileTestBase {
    LandingPage landingPage = new LandingPage();
    LoginPage loginPage = new LoginPage();
    AccountPage accountPage = new AccountPage();

    AuthUserDriver authConfig = new AuthUserDriver();

    String userEmail = authConfig.getUserEmail();
    String userPassword = authConfig.getUserPassword();
    String userName = authConfig.getUserName();

    @BeforeAll
    public static void beforeAll() {
        String deviceHost = System.getProperty("deviceHost");
        switch (deviceHost) {
            case "browserstack":
                Configuration.browser = BrowserstackDriver.class.getName();
                break;
            case "emulator":
                Configuration.browser = EmulatorDriver.class.getName();
                break;
            case "real":
                Configuration.browser = RealDeviceDriver.class.getName();
                break;
            default:
                throw new RuntimeException(
                        "Invalid value for 'deviceHost'. Valid values are: browserstack / emulator / real"
                );
        }
        Configuration.timeout = 30000;
        Configuration.browserSize = null;
    }

    @BeforeEach
    public void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    public void addTestAttachments() {
        String deviceHost = System.getProperty("deviceHost");
        String sessionId = sessionId().toString();

        TestAttachment.screenshotAs("Screenshot");
        TestAttachment.pageSource("Page source");

        closeWebDriver();

        if (deviceHost.equals("browserstack")) {
            TestAttachment.addVideo("Video", sessionId);
        }
    }
}
