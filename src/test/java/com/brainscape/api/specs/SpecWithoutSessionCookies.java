package com.brainscape.api.specs;

import com.brainscape.api.configs.ConfigProvider;
import io.restassured.specification.RequestSpecification;

import static com.brainscape.api.helpers.CustomAPIListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;

public class SpecWithoutSessionCookies {
    public static RequestSpecification request = with()
            .baseUri(ConfigProvider.getBaseURI())
            .basePath(ConfigProvider.getBasePath())
            .log().all()
            .filter(withCustomTemplates());

    public static RequestSpecification requestPOST = with()
            .baseUri(ConfigProvider.getBaseURI())
            .basePath(ConfigProvider.getBasePath())
            .contentType(JSON)
            .log().all()
            .filter(withCustomTemplates());

    public static RequestSpecification requestDELETE = with()
            .baseUri(ConfigProvider.getBaseURI())
            .log().all()
            .filter(withCustomTemplates());
}
