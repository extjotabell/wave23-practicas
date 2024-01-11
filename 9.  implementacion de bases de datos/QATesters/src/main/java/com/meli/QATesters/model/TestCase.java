package com.meli.QATesters.model;

import com.meli.QATesters.dto.TestCaseDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idCase;

    String description;

    Boolean tested;

    Boolean passed;

    int numberOfTries;

    LocalDate lastUpdate;

    // Constructor for POST (without idCase)
    public TestCase(String description, Boolean tested, Boolean passed, int numberOfTries, LocalDate lastUpdate) {
        this.description = description;
        this.tested = tested;
        this.passed = passed;
        this.numberOfTries = numberOfTries;
        this.lastUpdate = lastUpdate;
    }

    // Convert from DTO to Entity
    public TestCase(TestCaseDTO testCaseDTO) {
        this.description = testCaseDTO.getDescription();
        this.tested = testCaseDTO.getTested();
        this.passed = testCaseDTO.getPassed();
        this.numberOfTries = testCaseDTO.getNumberOfTries();
        this.lastUpdate = testCaseDTO.getLastUpdate();
    }
}
