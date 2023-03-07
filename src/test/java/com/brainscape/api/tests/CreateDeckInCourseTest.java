package com.brainscape.api.tests;

import com.brainscape.api.models.LombokDeck;
import com.brainscape.api.specs.SpecWithoutSessionCookies;
import com.brainscape.api.utils.DeckData;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.brainscape.api.specs.BasicSpec.basicRequestPOST;
import static com.brainscape.api.specs.BasicSpec.basicResponse;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;

public class CreateDeckInCourseTest extends ApiTestBase {

    @Test
    @Tag("API")
    @Feature("Deck creation")
    @Story("Successful deck creation")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Create a new deck with admin permission")
    @Owner("oschastlivtseva")
    public void createNewDeckAsAdmin() {

        step("Generate test data");
        int packId = 21280301;
        DeckData body = generalActions.generateDataForDeck();

        step("Attempt to create a new deck with admin permission");
        LombokDeck response = given()
                .spec(basicRequestPOST)
                .body(body)
                .when()
                .post("decks?packID=" + packId)
                .then()
                .spec(basicResponse)
                .log().body()
                .extract().as(LombokDeck.class);

        step("Assertions");
        softAssertions.assertThat(response.getName()).isEqualTo(body.getName());
        softAssertions.assertThat(response.getContentType()).isEqualTo(body.getContentType());
        softAssertions.assertThat(response.getPermission()).isEqualTo("admin");
        softAssertions.assertThat(response.getDeckId()).isEqualTo(response.getDeck());
        softAssertions.assertThat(response.getVkey()).contains(response.getDeckId());
        softAssertions.assertThat(response.getCardIds()).isEqualTo(response.getCards()).isEmpty();
        softAssertions.assertThat(response.getDesc()).isEmpty();
        softAssertions.assertAll();

        step("Check that new deck exist in the decks list");
        generalActions.checkDeckIdInCoursePackList(packId, response.getDeckId(), true);

        step("Delete test entities after test");
        generalActions.removeDeckFromCourse(packId, response.getDeckId());
    }

    @Test
    @Tag("API")
    @Feature("Deck creation")
    @Story("Failed deck creation")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Create a new deck without admin permission")
    @Owner("oschastlivtseva")
    public void createNewDeckAsNonAdmin() {

        step("Generate test data");
        int packId = 21216183;
        DeckData body = generalActions.generateDataForDeck();

        step("Attempt to create a new deck without admin permission");
        given()
                .spec(basicRequestPOST)
                .body(body)
                .when()
                .post("decks?packID=" + packId)
                .then()
                .statusCode(403)
                .log().body()
                .body("message", is("You do not have permission to create decks in this pack."));
    }

    @Test
    @Tag("API")
    @Feature("Deck creation")
    @Story("Failed deck creation")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Create a new deck in non-existent class")
    @Owner("oschastlivtseva")
    public void createNewDeckInNonexistentClass() {

        step("Generate test data");
        int packId = 99999999;
        DeckData body = generalActions.generateDataForDeck();

        step("Attempt to create a new deck in non-existent class");
        given()
                .spec(basicRequestPOST)
                .body(body)
                .when()
                .post("decks?packID=" + packId)
                .then()
                .statusCode(404)
                .log().body()
                .body("message", is("The class was not found."));
    }

    @Test
    @Tag("API")
    @Feature("Deck creation")
    @Story("Failed deck creation")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Create a new deck by unauthorized user")
    @Owner("oschastlivtseva")
    public void createDeckAsUnauthorizedUser() {

        step("Generate test data");
        int packId = 21280301;
        DeckData body = generalActions.generateDataForDeck();

        step("Attempt to create a new deck by unauthorized user");
        String plainTextErrorMessage = given()
                .spec(SpecWithoutSessionCookies.requestPOST)
                .body(body)
                .when()
                .post("decks?packID=" + packId)
                .then()
                .statusCode(403)
                .log().body()
                .extract().body().asString();

        assertThat(plainTextErrorMessage).isEqualTo("You must be logged in to perform this action.");
    }
}
