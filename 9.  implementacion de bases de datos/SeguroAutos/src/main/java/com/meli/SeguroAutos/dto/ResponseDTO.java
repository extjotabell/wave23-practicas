package com.meli.SeguroAutos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ResponseDTO {

    @JsonProperty("message")
    private String message;

}
