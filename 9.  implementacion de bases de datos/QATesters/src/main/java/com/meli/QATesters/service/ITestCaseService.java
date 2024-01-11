package com.meli.QATesters.service;

import com.meli.QATesters.dto.TestCaseDTO;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {

    List<TestCaseDTO> findAll();
    TestCaseDTO findById(Long id);
    TestCaseDTO save(TestCaseDTO testCaseDTO);
    TestCaseDTO update(Long id, TestCaseDTO testCaseDTO);
    void delete(Long id);

    List<TestCaseDTO> findByLastUpdateAfter(String date);
}
