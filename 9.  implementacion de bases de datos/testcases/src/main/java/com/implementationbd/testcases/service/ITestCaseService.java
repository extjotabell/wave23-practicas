package com.implementationbd.testcases.service;

import com.implementationbd.testcases.dto.TestCaseDto;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {

    void save(TestCaseDto testCase);

    List<TestCaseDto> getAll();

    TestCaseDto getById(Long id);

    void update(long id, TestCaseDto testCase);

    void delete(long id);

    List<TestCaseDto> getTestCasesUpdatedAfterDate(LocalDate lastUpdate);
}
