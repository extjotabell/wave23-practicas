package com.meli.QATesters.service;

import com.meli.QATesters.dto.request.TestCaseRequestDTO;
import com.meli.QATesters.dto.response.ResponseDTO;
import com.meli.QATesters.dto.response.TestCaseResponseDTO;
import com.meli.QATesters.dto.response.TestsCaseResponseDTO;
import com.meli.QATesters.entity.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface TestCaseService {

    ResponseDTO createTestCase(TestCaseRequestDTO testCaseRequestDTO);

    TestsCaseResponseDTO getTestsCase();

    TestCaseResponseDTO getTestCase(Long id);

    TestCaseResponseDTO modifyTestCase(Long id, TestCaseRequestDTO testCaseRequestDTO);

    ResponseDTO deleteTestCase(Long id);

    TestsCaseResponseDTO getTestCaseListForDate(LocalDate lastUpdate);

}
