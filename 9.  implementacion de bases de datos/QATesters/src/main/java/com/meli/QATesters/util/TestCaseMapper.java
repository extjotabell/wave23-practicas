package com.meli.QATesters.util;

import com.meli.QATesters.dto.request.TestCaseRequestDTO;
import com.meli.QATesters.dto.response.TestCaseResponseDTO;
import com.meli.QATesters.dto.response.TestsCaseResponseDTO;
import com.meli.QATesters.entity.TestCase;

import java.time.LocalDate;
import java.util.List;

public class TestCaseMapper {

    public static TestCase mapToTestCase(TestCaseRequestDTO testCaseRequestDTO){
        TestCase testCase = new TestCase();
        testCase.setDescription(testCaseRequestDTO.getDescription());
        testCase.setTested(testCaseRequestDTO.isTested());
        testCase.setPassed(testCaseRequestDTO.isPassed());
        testCase.setNumberOfTries(testCaseRequestDTO.getNumberOfTries());
        testCase.setLastUpdate(LocalDate.now());
        return testCase;
    }

    public static TestsCaseResponseDTO mapToTestsCaseResponseDTO(List<TestCase> testCaseList){
        return new TestsCaseResponseDTO(testCaseList.stream().map(TestCaseMapper::mapToTestCaseResponseDTO).toList());
    }

    public static TestCaseResponseDTO mapToTestCaseResponseDTO(TestCase testCase){
        return new TestCaseResponseDTO(testCase.getDescription(), testCase.isTested(), testCase.isPassed(),
                testCase.getNumberOfTries(), testCase.getLastUpdate());
    }

}
