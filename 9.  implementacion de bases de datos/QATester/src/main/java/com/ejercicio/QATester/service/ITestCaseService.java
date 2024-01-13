package com.ejercicio.QATester.service;

import com.ejercicio.QATester.dto.TestCaseDTO;

import java.util.List;

public interface ITestCaseService {
    TestCaseDTO createTestCase(TestCaseDTO testCaseDTO);
    TestCaseDTO updateTestCase(TestCaseDTO testCaseDTO, Long id);
    void deleteTestCase(Long id);
    TestCaseDTO getTestCaseById(Long id);
    List<TestCaseDTO> getAllTestCases();
    List<TestCaseDTO> getTestCasesByDate(String date);
}
