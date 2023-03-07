package com.brainscape.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LombokDeck {

    private String deckId;
    @JsonProperty("deckID")
    private String deck;
    private String name;
    private String contentType;
    private String permission;
    private String vkey;
    private String desc;
    private String cardIds;
    @JsonProperty("cardIDs")
    private String cards;

}