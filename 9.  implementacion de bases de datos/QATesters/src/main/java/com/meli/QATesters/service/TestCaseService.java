package com.meli.QATesters.service;

import com.meli.QATesters.dto.TestCaseDTO;
import com.meli.QATesters.exception.NotFoundException;
import com.meli.QATesters.model.TestCase;
import com.meli.QATesters.repository.ITestCaseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TestCaseService implements ITestCaseService {

    ITestCaseRepository repository;

    public TestCaseService(ITestCaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TestCaseDTO> findAll() {
        return repository.findAll()
            .stream()
            .map(TestCaseDTO::new)
            .toList();
    }

    @Override
    public TestCaseDTO findById(Long id) {
        return repository.findById(id)
            .map(TestCaseDTO::new)
            .orElseThrow(() -> new NotFoundException("Test case not found"));
    }

    @Override
    public TestCaseDTO save(TestCaseDTO testCaseDTO) {
        TestCase testCase = new TestCase(testCaseDTO);
        TestCase savedTestCase = repository.save(testCase);
        return new TestCaseDTO(savedTestCase);
    }

    @Override
    public TestCaseDTO update(Long id, TestCaseDTO testCaseDTO) {
        TestCase testCase = repository.findById(id)
            .orElseThrow(() -> new NotFoundException("Test case not found"));

        testCase.setDescription(testCaseDTO.getDescription());
        testCase.setTested(testCaseDTO.getTested());
        testCase.setPassed(testCaseDTO.getPassed());
        testCase.setNumberOfTries(testCaseDTO.getNumberOfTries());
        testCase.setLastUpdate(testCaseDTO.getLastUpdate());

        TestCase updatedTestCase = repository.save(testCase);

        return new TestCaseDTO(updatedTestCase);
    }

    @Override
    public void delete(Long id) {
        TestCase testCase = repository.findById(id)
            .orElseThrow(() -> new NotFoundException("Test case not found"));

        repository.delete(testCase);
    }

    @Override
    public List<TestCaseDTO> findByLastUpdateAfter(String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        return repository.findByLastUpdateGreaterThanEqual(localDate).stream()
            .map(TestCaseDTO::new)
            .toList();
    }

}
