package com.meli.tests.services.impl;

import com.meli.tests.dtos.request.TestCaseDTO;
import com.meli.tests.mappers.TestCaseMapper;
import com.meli.tests.repositories.ITestCaseRepository;
import com.meli.tests.services.ITestCaseService;
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

}