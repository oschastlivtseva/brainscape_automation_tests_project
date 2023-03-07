package com.brainscape.api.specs;

import com.brainscape.api.configs.ConfigProvider;
import io.restassured.specification.RequestSpecification;

import static com.brainscape.api.helpers.CustomAPIListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;

public class LoginSpec {

    public static RequestSpecification loginRequest = with()
            .baseUri(ConfigProvider.getBaseURI())
            .basePath(ConfigProvider.getBasePath())
            .contentType(JSON)
            .filter(withCustomTemplates());
}
