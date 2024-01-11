package com.meli.tests.services;

import com.meli.tests.dtos.request.TestCaseDTO;

public interface ITestCaseService {
    TestCaseDTO createTestCase(TestCaseDTO testCaseDTO);
}