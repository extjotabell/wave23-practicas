package com.ospina.qatesters.modelo.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class TestCaseRequestDTO {
    String description;
    Boolean tested;
    Boolean passed;
    @JsonProperty("number_of_tries")
    Integer numberOfTries;
    @JsonProperty("last_update")
    LocalDate lastUpdate;
}

