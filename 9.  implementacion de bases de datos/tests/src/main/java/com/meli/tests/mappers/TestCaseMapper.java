package com.meli.tests.mappers;

import com.meli.tests.dtos.request.TestCaseDTO;
import com.meli.tests.entities.TestCase;

public class TestCaseMapper {
    private TestCaseMapper(){}

    public static TestCase toEntity(TestCaseDTO testCaseDTO){
    return TestCase.builder()
                   .description(testCaseDTO.getDescription())
                   .tested(testCaseDTO.getTested())
                   .passed(testCaseDTO.getPassed())
                   .numberOfTries(testCaseDTO.getNumberOfTries())
                   .lastUpdate(testCaseDTO.getLastUpdate())
                   .build();
    }
    public static TestCaseDTO toDTO(TestCase testCase){
        return TestCaseDTO.builder()
                          .idCase(testCase.getIdCase())
                          .description(testCase.getDescription())
                          .tested(testCase.getTested())
                          .passed(testCase.getPassed())
                          .numberOfTries(testCase.getNumberOfTries())
                          .lastUpdate(testCase.getLastUpdate())
                          .build();
    }
}