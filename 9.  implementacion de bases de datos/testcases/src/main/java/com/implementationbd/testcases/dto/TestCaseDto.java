package com.implementationbd.testcases.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestCaseDto {
    String description;
    Boolean tested;
    Boolean passed;

    @JsonProperty("number_of_tries")
    int numberOfTries;

    @JsonProperty("last_update")
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate lastUpdate;
}
