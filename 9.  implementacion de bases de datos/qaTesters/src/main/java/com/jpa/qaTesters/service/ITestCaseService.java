package com.jpa.qaTesters.service;

import com.jpa.qaTesters.entity.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    TestCase saveTestCase(TestCase testCase);

    List<TestCase> findAllTestCases();

    TestCase findTestCaseById(Long id);

    TestCase updateTestCase(TestCase updatedTestCase, Long id);

    Long deleteTestCase(Long id);

    List<TestCase> getByLastUpdateGreaterThan(LocalDate localDate);
}
