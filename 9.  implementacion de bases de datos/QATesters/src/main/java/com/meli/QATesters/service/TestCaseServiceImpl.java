package com.meli.QATesters.service;

import com.meli.QATesters.dto.request.TestCaseRequestDTO;
import com.meli.QATesters.dto.response.ResponseDTO;
import com.meli.QATesters.dto.response.TestCaseResponseDTO;
import com.meli.QATesters.dto.response.TestsCaseResponseDTO;
import com.meli.QATesters.entity.TestCase;
import com.meli.QATesters.exception.exceptions.NotFoundException;
import com.meli.QATesters.repository.TestCaseRepository;
import com.meli.QATesters.util.TestCaseMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseServiceImpl implements TestCaseService{

    private final TestCaseRepository testCaseRepository;

    public TestCaseServiceImpl(TestCaseRepository testCaseRepository){
        this.testCaseRepository = testCaseRepository;
    }

    @Override
    public ResponseDTO createTestCase(TestCaseRequestDTO testCaseRequestDTO) {
        testCaseRepository.save(TestCaseMapper.mapToTestCase(testCaseRequestDTO));
        return new ResponseDTO("A new TestCase has been created");
    }

    @Override
    public TestsCaseResponseDTO getTestsCase() {
        return TestCaseMapper.mapToTestsCaseResponseDTO(testCaseRepository.findAll());
    }

    @Override
    public TestCaseResponseDTO getTestCase(Long id) {
        return TestCaseMapper.mapToTestCaseResponseDTO(validateTestCaseById(id));
    }

    @Override
    public TestCaseResponseDTO modifyTestCase(Long id, TestCaseRequestDTO testCaseRequestDTO) {
        validateTestCaseById(id);
        TestCase testCase = TestCaseMapper.mapToTestCase(testCaseRequestDTO);
        testCase.setIdCase(id);
        return TestCaseMapper.mapToTestCaseResponseDTO(testCaseRepository.save(testCase));
    }

    @Override
    public ResponseDTO deleteTestCase(Long id) {
        validateTestCaseById(id);
        testCaseRepository.deleteById(id);
        return new ResponseDTO("The TestCase with id " + id + " has been successfully deleted");
    }

    public TestsCaseResponseDTO getTestCaseListForDate(LocalDate lastUpdate){
        return TestCaseMapper.mapToTestsCaseResponseDTO(testCaseRepository.findAll().stream()
                .filter(testCase -> !testCase.getLastUpdate().isBefore(lastUpdate)).toList());
    }

    public TestCase validateTestCaseById(Long id){
        return testCaseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("The TestCase with id " + id + " not found."));
    }
}
