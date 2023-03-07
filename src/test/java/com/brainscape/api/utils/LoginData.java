package com.brainscape.api.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginData {
    private String email;
    private String password;
    @JsonProperty("remember_me")
    private Boolean rememberMe;
    private Boolean web;

    public LoginData(String email, String password, Boolean rememberMe, Boolean web) {
        this.email = email;
        this.password = password;
        this.rememberMe = rememberMe;
        this.web = web;
    }
}
