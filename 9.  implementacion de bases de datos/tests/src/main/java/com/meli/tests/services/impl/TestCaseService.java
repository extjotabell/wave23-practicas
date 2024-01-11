package com.meli.tests.services.impl;

import com.meli.tests.dtos.request.TestCaseDTO;
import com.meli.tests.entities.TestCase;
import com.meli.tests.mappers.TestCaseMapper;
import com.meli.tests.repositories.ITestCaseRepository;
import com.meli.tests.services.ITestCaseService;
import com.meli.tests.exceptions.custom.NotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCaseService implements ITestCaseService {

    private final ITestCaseRepository testCaseRepository;

    public TestCaseService(ITestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    @Override
    public TestCaseDTO createTestCase(TestCaseDTO testCaseDTO) {
        return TestCaseMapper.toDTO(testCaseRepository.save(TestCaseMapper.toEntity(testCaseDTO)));
    }

    @Override
    public List<TestCaseDTO> getAllTestCases() {
        return testCaseRepository.findAll().stream().map(TestCaseMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public TestCaseDTO getTestCaseById(Long id) {
        return testCaseRepository.findById(id).map(TestCaseMapper::toDTO).orElseThrow(() -> new NotFoundException("Test case not found"));
    }

    @Override
    public TestCaseDTO updateTestCase(Long id, TestCaseDTO testCaseDTO) {
        TestCase testCase = testCaseRepository.findById(id).orElseThrow(() -> new NotFoundException("Test case not found"));
        testCase.setTested(testCaseDTO.getTested());
        testCase.setPassed(testCaseDTO.getPassed());
        testCase.setNumberOfTries(testCaseDTO.getNumberOfTries());
        testCase.setLastUpdate(testCaseDTO.getLastUpdate());
        testCaseRepository.save(testCase);
        return TestCaseMapper.toDTO(testCaseRepository.findById(id).get());
    }

}