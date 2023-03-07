package com.brainscape.api.tests;

import com.brainscape.api.configs.ConfigProvider;
import com.brainscape.api.models.LombokProfile;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.brainscape.api.specs.BasicSpec.basicRequest;
import static com.brainscape.api.specs.BasicSpec.basicResponse;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class UserProfileInfoTest extends ApiTestBase {
    static LombokProfile profile = new LombokProfile();

    @BeforeAll
    public static void configureUserProfile() {
        profile.setFirstName(ConfigProvider.getUserName());
        profile.setLastName(ConfigProvider.getUserLastName());
        profile.setFullName(format("%s %s", profile.getFirstName(), profile.getLastName()));
        profile.setDisplayName(format("%s, %s", profile.getLastName(), profile.getFirstName()));
        profile.setEmail(ConfigProvider.getUserEmail());
        profile.setIsAdmin(false);
        profile.setIsPro(false);
        profile.setUserId(ConfigProvider.getUserId());
        profile.setProfileId(ConfigProvider.getProfileId());
        profile.setProfilePath(format("/profiles/%s", profile.getProfileId()));
        profile.setVersion(1);
    }

    @Test
    @Tag("API")
    @Feature("User Profile info")
    @Story("Get user profile info")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Get user's profile info via /api/profile")
    @Owner("oschastlivtseva")
    public void checkProfileInfo() {

        step("Get user's profile info");
        LombokProfile response = given()
                .spec(basicRequest)
                .when()
                .get("profile")
                .then()
                .spec(basicResponse)
                .log().body()
                .extract().as(LombokProfile.class);

        step("Assertions");
        softAssertions.assertThat(response.getFirstName()).isEqualTo(profile.getFirstName());
        softAssertions.assertThat(response.getLastName()).isEqualTo(profile.getLastName());
        softAssertions.assertThat(response.getFullName()).isEqualTo(profile.getFullName());
        softAssertions.assertThat(response.getDisplayName()).isEqualTo(profile.getDisplayName());
        softAssertions.assertThat(response.getEmail()).isEqualTo(profile.getEmail());
        softAssertions.assertThat(response.getIsAdmin()).isEqualTo(profile.getIsAdmin());
        softAssertions.assertThat(response.getIsPro()).isEqualTo(profile.getIsPro());
        softAssertions.assertThat(response.getUserId()).isEqualTo(profile.getUserId());
        softAssertions.assertThat(response.getProfileId()).isEqualTo(profile.getProfileId());
        softAssertions.assertThat(response.getProfilePath()).isEqualTo(profile.getProfilePath());
        softAssertions.assertThat(response.getVersion()).isEqualTo(profile.getVersion());
        softAssertions.assertThat(response.getAvatarURL()).isNotNull();
        softAssertions.assertThat(response.getHasMobileActivity()).isFalse();
        softAssertions.assertThat(response.getCardsStudied()).isNotNull();
        softAssertions.assertThat(response.getDaysStreak()).isNotNull();
        softAssertions.assertThat(response.getDecksCreated()).isNotNull();
        softAssertions.assertThat(response.getNotificationsCount()).isNotNull();
        softAssertions.assertThat(response.getPackCount()).isNotNull();
        softAssertions.assertAll();
    }

    @Test
    @Tag("API")
    @Feature("User Profile info")
    @Story("Get user profile info")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Get user's profile info via /api/v2/me/profile")
    @Owner("oschastlivtseva")
    public void checkProfileInfoV2() {

        step("Get user's profile info");
        LombokProfile response = given()
                .spec(basicRequest)
                .when()
                .get("v2/me/profile?is_web=true")
                .then()
                .spec(basicResponse)
                .log().body()
                .extract().as(LombokProfile.class);

        step("Assertions");
        softAssertions.assertThat(response.getFirstName()).isEqualTo(profile.getFirstName());
        softAssertions.assertThat(response.getLastName()).isEqualTo(profile.getLastName());
        softAssertions.assertThat(response.getFullName()).isEqualTo(profile.getFullName());
        softAssertions.assertThat(response.getDisplayName()).isEqualTo(profile.getDisplayName());
        softAssertions.assertThat(response.getEmail()).isEqualTo(profile.getEmail());
        softAssertions.assertThat(response.getIsAdmin()).isEqualTo(profile.getIsAdmin());
        softAssertions.assertThat(response.getIsPro()).isEqualTo(profile.getIsPro());
        softAssertions.assertThat(response.getUserId()).isEqualTo(profile.getUserId());
        softAssertions.assertThat(response.getProfileId()).isEqualTo(profile.getProfileId());
        softAssertions.assertThat(response.getProfilePath()).isEqualTo(profile.getProfilePath());
        softAssertions.assertThat(response.getVersion()).isEqualTo(profile.getVersion());
        softAssertions.assertThat(response.getAvatar()).isNotNull();
        softAssertions.assertThat(response.getHasMobileActivity()).isFalse();
        softAssertions.assertThat(response.getCardsStudied()).isNotNull();
        softAssertions.assertThat(response.getDaysStreak()).isNotNull();
        softAssertions.assertThat(response.getDecksCreated()).isNotNull();
        softAssertions.assertThat(response.getNotificationsCount()).isNotNull();
        softAssertions.assertThat(response.getPackCount()).isNotNull();
        softAssertions.assertThat(response.getSchoolName()).isNotNull();
        softAssertions.assertThat(response.getCompanyName()).isNotNull();
        softAssertions.assertThat(response.getBio()).isNotNull();
        softAssertions.assertThat(response.getIdentityProviders()).isNotNull();
        softAssertions.assertAll();
    }
}