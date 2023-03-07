package com.brainscape.mobile.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class LandingPage {

    public SelenideElement loginButton = $(xpath("//*[@resource-id=\"loginButton\"]"));

    public void clickLoginButton() {
        loginButton.click();
    }
}
