package com.example.QATesters.service;

import com.example.QATesters.dto.MessageDTO;
import com.example.QATesters.dto.TestCaseDTO;
import com.example.QATesters.entity.TestCase;
import com.example.QATesters.repository.ITestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCaseService implements ITestCaseService{

    @Autowired
    ITestCaseRepository repository;

    @Override
    public MessageDTO addTestCase(TestCaseDTO testCaseDTO) {
        TestCase testCase = mapToEntity(testCaseDTO);
        repository.save(testCase);
        return new MessageDTO("Test case save successfully.");
    }

    @Override
    public List<TestCaseDTO> getAllTestCases() {
        List<TestCase> testCases = repository.findAll();
        return testCases.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TestCaseDTO getTestCaseByID(Long id) {
        TestCase testCase = validateTestCase(id);
        return mapToDTO(testCase);
    }

    @Override
    public TestCaseDTO updateTestCase(Long id, TestCaseDTO testCaseDTO) {
        TestCase testCase = validateTestCase(id);
        testCase.setTested(testCaseDTO.getTested());
        testCase.setLastUpdate(testCaseDTO.getLastUpdate());
        testCase.setDescription(testCaseDTO.getDescription());
        testCase.setPassed(testCaseDTO.getPassed());
        testCase.setNumberOfTries(testCaseDTO.getNumberOfTries());
        repository.save(testCase);
        return mapToDTO(testCase);
    }

    @Override
    public MessageDTO deleteTestCase(Long id) {
        TestCase testCase = validateTestCase(id);
        repository.delete(testCase);
        return new MessageDTO("Test case deleted successfully.");
    }

    @Override
    public List<TestCaseDTO> getTestCasePostDate(LocalDate date) {
        List<TestCase> testCases = repository.findByLastUpdateAfter(date);
        return testCases.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private TestCase validateTestCase(Long id) {
        TestCase testCase = repository.findById(id).orElse(null);

        if(testCase == null){
            throw new RuntimeException("Test case not exists.");
        }

        return testCase;
    }

    private TestCaseDTO mapToDTO(TestCase testCase){
        TestCaseDTO dto = new TestCaseDTO();
        dto.setId(testCase.getId());
        dto.setTested(testCase.getTested());
        dto.setPassed(testCase.getPassed());
        dto.setDescription(testCase.getDescription());
        dto.setLastUpdate(testCase.getLastUpdate());
        dto.setNumberOfTries(testCase.getNumberOfTries());
        return dto;
    }

    private TestCase mapToEntity(TestCaseDTO testCaseDTO) {
        TestCase testCase = new TestCase();
        testCase.setId(testCaseDTO.getId());
        testCase.setDescription(testCaseDTO.getDescription());
        testCase.setTested(testCaseDTO.getTested());
        testCase.setPassed(testCaseDTO.getPassed());
        testCase.setLastUpdate(testCaseDTO.getLastUpdate());
        testCase.setNumberOfTries(testCaseDTO.getNumberOfTries());
        return testCase;
    }
}
