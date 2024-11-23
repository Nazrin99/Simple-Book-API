package com.example.servicedeskapi.payload.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResolutionBody {

    @JsonProperty("content")
    private String content;

    // Default constructor for Jackson
    public ResolutionBody() {}

    // Getter and Setter
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
