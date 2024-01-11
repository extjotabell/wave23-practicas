package com.meli.tests.services;

import com.meli.tests.dtos.request.TestCaseDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ITestCaseService {
    TestCaseDTO createTestCase(TestCaseDTO testCaseDTO);
    List<TestCaseDTO> getAllTestCases(Optional<LocalDate> lastUpdate);
    TestCaseDTO getTestCaseById(Long id);
    TestCaseDTO updateTestCase(Long id, TestCaseDTO testCaseDTO);
    Boolean deleteTestCase(Long id);
}