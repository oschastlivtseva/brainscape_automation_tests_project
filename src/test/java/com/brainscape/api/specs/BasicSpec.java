package com.brainscape.api.specs;

import com.brainscape.api.configs.ConfigProvider;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static com.brainscape.api.helpers.CustomAPIListener.withCustomTemplates;
import static com.brainscape.api.tests.ApiTestBase.cookieName;
import static com.brainscape.api.tests.ApiTestBase.cookieValue;
import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;

public class BasicSpec {
    public static RequestSpecification basicRequest = with()
            .baseUri(ConfigProvider.getBaseURI())
            .basePath(ConfigProvider.getBasePath())
            .cookie(cookieName, cookieValue)
            .log().all()
            .filter(withCustomTemplates());

    public static RequestSpecification basicRequestPOST = with()
            .baseUri(ConfigProvider.getBaseURI())
            .basePath(ConfigProvider.getBasePath())
            .contentType(JSON)
            .cookie(cookieName, cookieValue)
            .log().all()
            .filter(withCustomTemplates());

    public static RequestSpecification basicRequestDELETE = with()
            .baseUri(ConfigProvider.getBaseURI())
            .cookie(cookieName, cookieValue)
            .log().all()
            .filter(withCustomTemplates());

    public static ResponseSpecification basicResponse = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
}
