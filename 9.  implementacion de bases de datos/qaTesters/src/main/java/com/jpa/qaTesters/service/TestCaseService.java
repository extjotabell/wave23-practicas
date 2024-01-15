package com.jpa.qaTesters.service;

import com.jpa.qaTesters.entity.TestCase;
import com.jpa.qaTesters.repository.ITestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TestCaseService implements ITestCaseService {
    @Autowired
    private ITestCaseRepository testCaseRepository;
    @Override
    public TestCase saveTestCase(TestCase testCase) {
        return testCaseRepository.save(testCase);
    }

    @Override
    public List<TestCase> findAllTestCases() {
        return testCaseRepository.findAll();
    }

    @Override
    public TestCase findTestCaseById(Long id) {
        Optional<TestCase> testCase = testCaseRepository.findById(id);
        //Generic exception just for the exercise, in production don't do this!
        if (testCase.isEmpty()) throw new RuntimeException("Test case not found");
        return testCase.get();
    }

    @Override
    public TestCase updateTestCase(TestCase updatedTestCase, Long id) {
        Optional<TestCase> optionalTestCase = testCaseRepository.findById(id);
        if (optionalTestCase.isEmpty()) throw new RuntimeException("Test case not found");
        TestCase currentTestCase = optionalTestCase.get();
        currentTestCase
                .idCase(updatedTestCase.idCase())
                .description(updatedTestCase.description())
                .tested(updatedTestCase.passed())
                .passed(updatedTestCase.passed())
                .numberOfTries(updatedTestCase.numberOfTries())
                .lastUpdate(updatedTestCase.lastUpdate());
        return currentTestCase;
    }

    @Override
    public Long deleteTestCase(Long id) {
        testCaseRepository.deleteById(id);
        return id;
    }

    @Override
    public List<TestCase> getByLastUpdateGreaterThan(LocalDate localDate) {
        return testCaseRepository.findByLastUpdateGreaterThan(localDate);
    }


}
