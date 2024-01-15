package com.meli.QATesters.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class TestCaseRequestDTO {

    @JsonProperty("description")
    private String description;
    @JsonProperty("tested")
    private boolean tested;
    @JsonProperty("passed")
    private boolean passed;
    @JsonProperty("number_of_tries")
    private int numberOfTries;

}
