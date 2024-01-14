package com.example.QATesters.service;

import com.example.QATesters.dto.MessageDTO;
import com.example.QATesters.dto.TestCaseDTO;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    MessageDTO addTestCase(TestCaseDTO testCaseDTO);
    List<TestCaseDTO> getAllTestCases();
    TestCaseDTO getTestCaseByID(Long id);
    TestCaseDTO updateTestCase(Long id, TestCaseDTO testCaseDTO);
    MessageDTO deleteTestCase(Long id);
    List<TestCaseDTO> getTestCasePostDate(LocalDate date);

}
