package com.example.casosprueba.service;

import com.example.casosprueba.dto.TestCaseDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {

    TestCaseDTO addTestCase(TestCaseDTO dto);
    List<TestCaseDTO> getAllTestCases();
    TestCaseDTO getTestCase(long number);
    TestCaseDTO updateTestCase(long number, TestCaseDTO dto);
    TestCaseDTO deleteTestCase(long number);
    List<TestCaseDTO> getAllTestCasesAfterUpdateDate(LocalDate date);





}
