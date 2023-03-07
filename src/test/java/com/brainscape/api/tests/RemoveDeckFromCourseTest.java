package com.brainscape.api.tests;

import com.brainscape.api.specs.SpecWithoutSessionCookies;
import com.brainscape.api.utils.DeckData;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.brainscape.api.specs.BasicSpec.basicRequestDELETE;
import static com.brainscape.api.specs.BasicSpec.basicResponse;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class RemoveDeckFromCourseTest extends ApiTestBase {

    @Test
    @Tag("API")
    @Feature("Deck removal")
    @Story("Successful deck removal")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Remove deck with admin permission")
    @Owner("oschastlivtseva")
    public void removeDeckAsAdmin() {

        step("Generate test data");
        int packId = 21280301;
        DeckData body = generalActions.generateDataForDeck();
        String deckId = generalActions.createDeckInCourse(packId, body);

        step("Check that test deck is created");
        generalActions.checkDeckIdInCoursePackList(packId, deckId, true);

        step("Attempt to remove deck with admin permission");
        given()
                .spec(basicRequestDELETE)
                .when()
                .delete("packs/" + packId + "/deck/" + deckId + ".json")
                .then()
                .log().body()
                .spec(basicResponse)
                .body(is("{}"));

        step("Check that deck is removed");
        generalActions.checkDeckIdInCoursePackList(packId, deckId, false);
    }

    @Test
    @Tag("API")
    @Feature("Deck removal")
    @Story("Failed deck removal")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Remove deck without admin permission")
    @Owner("oschastlivtseva")
    public void removeDeckAsNonAdmin() {

        step("Generate test data");
        int packId = 21067381;
        String deckId = "11814626";

        step("Attempt to remove deck without admin permission");
        given()
                .spec(basicRequestDELETE)
                .when()
                .delete("packs/" + packId + "/deck/" + deckId + ".json")
                .then()
                .log().body()
                .statusCode(401)
                .body("message", is("You don't have permissions necessary to delete this deck."));

        step("Check that deck is still in decks list");
        generalActions.checkDeckIdInCoursePackList(packId, deckId, true);
    }

    @Test
    @Tag("API")
    @Feature("Deck removal")
    @Story("Failed deck removal")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Remove a non-existent deck")
    @Owner("oschastlivtseva")
    public void removeNonExistentDeck() {

        step("Generate test data");
        int packId = 21280301;
        String deckId = "999999999";
        generalActions.checkDeckIdInCoursePackList(packId, deckId, false);

        step("Attempt to remove a non-existent deck");
        given()
                .spec(basicRequestDELETE)
                .when()
                .delete("packs/" + packId + "/deck/" + deckId + ".json")
                .then()
                .statusCode(404)
                .log().body()
                .body("error", is("Couldn't find BsStudy::Deck with 'id'=" + deckId));
    }

    @Test
    @Tag("API")
    @Feature("Deck removal")
    @Story("Failed deck removal")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Remove deck by an unauthorized user")
    @Owner("oschastlivtseva")
    public void removeDeckAsUnauthorizedUser() {

        step("Generate test data");
        int packId = 21280301;
        DeckData body = generalActions.generateDataForDeck();
        String deckId = generalActions.createDeckInCourse(packId, body);

        step("Check that test deck is created");
        generalActions.checkDeckIdInCoursePackList(packId, deckId, true);

        step("Attempt to remove deck by an unauthorized user");
        given()
                .spec(SpecWithoutSessionCookies.requestDELETE)
                .when()
                .delete("packs/" + packId + "/deck/" + deckId + ".json")
                .then()
                .log().body();

        step("Check that deck is still in decks list");
        generalActions.checkDeckIdInCoursePackList(packId, deckId, true);

        step("Delete test entities after test");
        generalActions.removeDeckFromCourse(packId, deckId);
    }
}
