package com.brainscape.api.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeckData {
    private String name;
    private String contentType;

    public DeckData(String name, String contentType) {
        this.name = name;
        this.contentType = contentType;
    }
}
