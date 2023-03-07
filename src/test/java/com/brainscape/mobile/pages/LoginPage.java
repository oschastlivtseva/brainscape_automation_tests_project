package com.brainscape.mobile.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class LoginPage {

    public SelenideElement
            emailInput = withResourceId("signInEmailTextInput"),
            passwordInput = withResourceId("signInPasswordTextInput"),
            completeLoginButton = withResourceId("loginApiButton"),
            forgotPasswordButton = withText("Forgot Password?"),
            dontHaveAccountButton = withText("Don't have an account?"),
            signUpButton = withText("Sign up");

    public SelenideElement
            welcomeTitle = withText("Welcome Back"),
            alertTitle = withResourceId("android:id/alertTitle"),
            alertText = withResourceId("android:id/message");


    public SelenideElement withResourceId(String value) {
        return $(xpath("//*[@resource-id=\"" + value + "\"]"));
    }

    public SelenideElement withText(String value) {
        return $(xpath("//*[@text=\"" + value + "\"]"));
    }

    public LoginPage checkElementIsVisible(SelenideElement element) {
        element.shouldBe(Condition.visible);

        return this;
    }

    public LoginPage checkElementHasText(SelenideElement element, String text) {
        element.shouldHave(Condition.text(text));

        return this;
    }

    public LoginPage clickButton(SelenideElement element) {
        element.click();

        return this;
    }

    public LoginPage inputInField(SelenideElement element, String value) {
        element.sendKeys(value);

        return this;
    }
}
