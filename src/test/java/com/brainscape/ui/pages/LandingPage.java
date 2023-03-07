package com.brainscape.ui.pages;

import com.brainscape.ui.pages.elements.Element;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class LandingPage {

    public Element registrationButton = new Element("'Get Started' button", $("#registration-button"));
    public Element loginButton = new Element("'Login' button", $("#login-button"));
    public Element watchVideoButton = new Element("'Watch video' button", $(".watch-video-button"));

    public LandingPage clickOnLandingPage(Element element) {
        step("Click on element: " + element.getName(), () -> {
            element.getElement().click();
        });

        return this;
    }
}
