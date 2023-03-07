package com.brainscape.mobile.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class AccountPage {
    public SelenideElement studyButton = $(xpath("//*[@resource-id=\"StudyButton\"]"));

    public AccountPage checkElementIsVisible(SelenideElement element) {
        element.shouldBe(visible);

        return this;
    }

    public AccountPage checkGreetingsHeader(String userName) {
        $(xpath("//*[@text=\"Hi, " + userName + "!\"]")).shouldBe(visible);

        return this;
    }
}
