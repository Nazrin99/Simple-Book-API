package com.example.servicedeskapi.payload.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestBody {

    @JsonProperty("request")
    private RequestDetailsBody requestDetails;

    // Default constructor for Jackson
    public RequestBody() {}

    // Getter and Setter for requestDetails
    public RequestDetailsBody getRequestDetails() {
        return requestDetails;
    }

    public void setRequestDetails(RequestDetailsBody requestDetails) {
        this.requestDetails = requestDetails;
    }
}
