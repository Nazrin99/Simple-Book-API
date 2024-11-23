package com.example.servicedeskapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)  // Ignore unknown properties in JSON
public class Request {

    @JsonProperty("request")
    private RequestDetails requestDetails;

    // Default constructor for Jackson
    public Request() {}

    // Getter and Setter for requestDetails
    public RequestDetails getRequestDetails() {
        return requestDetails;
    }

    public void setRequestDetails(RequestDetails requestDetails) {
        this.requestDetails = requestDetails;
    }
}
