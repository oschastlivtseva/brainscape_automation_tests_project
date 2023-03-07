package com.brainscape.api.tests;

import com.brainscape.api.configs.ConfigProvider;
import com.brainscape.api.helpers.GeneralActions;
import com.brainscape.api.utils.LoginData;
import lombok.SneakyThrows;
import org.assertj.core.api.SoftAssertions;

import static com.brainscape.api.specs.LoginSpec.loginRequest;
import static io.restassured.RestAssured.given;

public class ApiTestBase {
    GeneralActions generalActions = new GeneralActions();
    SoftAssertions softAssertions = new SoftAssertions();

    private static String headerName = "X-BS-AFT";
    public static String cookieName = "_Brainscape_session_1";

    public static String cookieValue = getSessionCookie();

    @SneakyThrows
    private static String getSessionCookie() {
        LoginData loginData = new LoginData(
                ConfigProvider.getUserEmail(),
                ConfigProvider.getUserPassword(),
                true,
                true
        );

        String header = given()
                .spec(loginRequest)
                .body(loginData)
                .when()
                .post("sessions/sign_in")
                .then()
                .log().all()
                .statusCode(401)
                .extract()
                .header(headerName);

        /*
        Waiting for the header "X-BS-AFT" to become valid so that we can log in successfully.
        'Awaitility' library wouldn't help, because every time POST 'sessions/sign_in' is called,
        a new 'X-BS-AFT' header with the new value will be generated.
         */
        Thread.sleep(10000);

        return given()
                .spec(loginRequest)
                .body(loginData)
                .header(headerName, header)
                .when()
                .post("sessions/sign_in")
                .then()
                .statusCode(200)
                .log().all()
                .extract()
                .cookie(cookieName);
    }
}
