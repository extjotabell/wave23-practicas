package com.meli.tests.services;

import com.meli.tests.dtos.request.TestCaseDTO;

import java.util.List;

public interface ITestCaseService {
    TestCaseDTO createTestCase(TestCaseDTO testCaseDTO);
    List<TestCaseDTO> getAllTestCases();

    TestCaseDTO getTestCaseById(Long id);

    TestCaseDTO updateTestCase(Long id, TestCaseDTO testCaseDTO);
}