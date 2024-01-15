package com.meli.JoyeriaLasPerlas.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ResponseDTO {
    @JsonProperty("message")
    private String message;
}
