package com.brainscape.api.helpers;

import com.brainscape.api.specs.BasicSpec;
import com.brainscape.api.utils.DataGenerator;
import com.brainscape.api.utils.DeckData;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class GeneralActions {
    DataGenerator dataGenerator = new DataGenerator();

    public void checkDeckIdInCoursePackList(int packId, String deckId, Boolean shouldExist) {
        if (shouldExist) {
            given()
                    .spec(BasicSpec.basicRequest)
                    .when()
                    .get("packs/" + packId + "/user_packs")
                    .then()
                    .spec(BasicSpec.basicResponse)
                    .log().body()
                    .body("userPack.deckIds", hasItem(deckId));
        } else {
            List<String> deckIds = given()
                    .spec(BasicSpec.basicRequest)
                    .when()
                    .get("packs/" + packId + "/user_packs")
                    .then()
                    .spec(BasicSpec.basicResponse)
                    .log().body()
                    .extract()
                    .path("userPack.deckIds");

            assertThat(deckIds).doesNotContain(deckId);
        }
    }

    public DeckData generateDataForDeck() {
        String deckName = dataGenerator.generateDeckName();
        String contentType = "md";

        return new DeckData(
                deckName,
                contentType
        );
    }

    public String createDeckInCourse(int packId, DeckData body) {
        return given()
                .spec(BasicSpec.basicRequestPOST)
                .body(body)
                .when()
                .post("decks?packID=" + packId)
                .then()
                .spec(BasicSpec.basicResponse)
                .log().body()
                .extract()
                .path("deckId");
    }

    public void removeDeckFromCourse(int packId, String deckId) {
        given()
                .spec(BasicSpec.basicRequestDELETE)
                .when()
                .delete("packs/" + packId + "/deck/" + deckId + ".json")
                .then()
                .log().body()
                .spec(BasicSpec.basicResponse);
    }
}
