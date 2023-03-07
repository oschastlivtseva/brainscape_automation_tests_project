package com.brainscape.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.net.URL;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LombokProfile {

    private String firstName;
    private String lastName;
    private String fullName;
    private String displayName;
    private String email;
    private String profilePath;
    private String schoolName;
    private String companyName;
    private String bio;

    @JsonProperty("avatarURL")
    private URL avatarURL;
    @JsonProperty("avatarUrl")
    private URL avatar;

    private Boolean isAdmin;
    private Boolean isPro;
    private Boolean hasMobileActivity;

    private Integer userId;
    private Integer profileId;
    private Integer cardsStudied;
    private Integer daysStreak;
    private Integer decksCreated;
    private Integer notificationsCount;
    private Integer packCount;
    private Integer version;

    private List<String> identityProviders;

}
