package com.meli.QATesters.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.meli.QATesters.model.TestCase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestCaseDTO {

    @JsonProperty("id_case")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long idCase;

    @JsonProperty("description")
    private String description;

    @JsonProperty("tested")
    private Boolean tested;

    @JsonProperty("passed")
    private Boolean passed;

    @JsonProperty("number_of_tries")
    private int numberOfTries;

    @JsonProperty("last_update")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate lastUpdate;

    // Constructor for POST (without idCase)
    public TestCaseDTO(String description, Boolean tested, Boolean passed, int numberOfTries, LocalDate lastUpdate) {
        this.description = description;
        this.tested = tested;
        this.passed = passed;
        this.numberOfTries = numberOfTries;
        this.lastUpdate = lastUpdate;
    }

    // Convert from Entity to DTO
    public TestCaseDTO(TestCase testCase) {
        this.idCase = testCase.getIdCase();
        this.description = testCase.getDescription();
        this.tested = testCase.getTested();
        this.passed = testCase.getPassed();
        this.numberOfTries = testCase.getNumberOfTries();
        this.lastUpdate = testCase.getLastUpdate();
    }
}
