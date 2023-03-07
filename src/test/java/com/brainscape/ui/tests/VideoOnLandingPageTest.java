package com.brainscape.ui.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class VideoOnLandingPageTest extends TestBase {

    @Test
    @Tag("UI")
    @Feature("Commercial Video")
    @Story("Video on the Landing page")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Check the video on the Landing page")
    @Owner("oschastlivtseva")
    public void checkVideoOnLandingPage() {
        landingPage.clickOnLandingPage(landingPage.watchVideoButton);
        generalActions.checkVisibility(modalPage.videoModalWindow);
        generalActions.checkVisibility(modalPage.closeModalButton);

        generalActions.checkThatElementContains(
                modalPage.video,
                "https://www.youtube.com/embed/", "autoplay=1");
        generalActions.switchToFrame(modalPage.video);
        modalPage.checkVideoIsPlaying();
    }
}
