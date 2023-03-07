package com.brainscape.mobile.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class LoginTest extends MobileTestBase {

    @Test
    @Tag("Mobile")
    @Feature("Login")
    @Story("Login form visibility")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Check the login form visibility")
    @Owner("oschastlivtseva")
    public void checkLoginFormVisibility() {

        step("Click button: 'Login'", () -> {
            landingPage.clickLoginButton();
        });

        step("Check that items on login page are visible", () -> {
            loginPage
                    .checkElementIsVisible(loginPage.welcomeTitle)
                    .checkElementIsVisible(loginPage.emailInput)
                    .checkElementIsVisible(loginPage.passwordInput)
                    .checkElementIsVisible(loginPage.completeLoginButton)
                    .checkElementIsVisible(loginPage.forgotPasswordButton)
                    .checkElementIsVisible(loginPage.dontHaveAccountButton)
                    .checkElementIsVisible(loginPage.signUpButton);
        });
    }

    @Test
    @Tag("Mobile")
    @Feature("Login")
    @Story("Successful login")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Check successful login via email")
    @Owner("oschastlivtseva")
    public void checkSuccessfulLogin() {

        step("Click button: 'Login'", () -> {
            landingPage.clickLoginButton();
        });

        step("Fill email field", () -> {
            loginPage.inputInField(loginPage.emailInput, userEmail);
        });

        step("Fill password field", () -> {
            loginPage.inputInField(loginPage.passwordInput, userPassword);
        });

        step("Click button: 'Login'", () -> {
            loginPage.clickButton(loginPage.completeLoginButton);
        });

        step("Check that login is completed", () -> {
            accountPage
                    .checkGreetingsHeader(userName)
                    .checkElementIsVisible(accountPage.studyButton);
        });
    }

    @Test
    @Tag("Mobile")
    @Feature("Login")
    @Story("Failed login")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Check login failed due to an invalid credentials")
    @Owner("oschastlivtseva")
    public void checkLoginFailedDueToWrongCreds() {

        step("Click button: 'Login'", () -> {
            landingPage.clickLoginButton();
        });

        step("Fill email field", () -> {
            loginPage.inputInField(loginPage.emailInput, userEmail);
        });

        step("Fill password field", () -> {
            loginPage.inputInField(loginPage.passwordInput, userPassword + "123");
        });

        step("Click button: 'Login'", () -> {
            loginPage.clickButton(loginPage.completeLoginButton);
        });

        step("Check that login is failed", () -> {
            loginPage
                    .checkElementHasText(loginPage.alertTitle, "Sign In Error")
                    .checkElementHasText(loginPage.alertText, "Please try again: invalid email or password");
        });
    }
}
