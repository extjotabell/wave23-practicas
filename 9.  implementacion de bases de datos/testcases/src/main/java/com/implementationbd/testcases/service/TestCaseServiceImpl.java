package com.implementationbd.testcases.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.implementationbd.testcases.dto.TestCaseDto;
import com.implementationbd.testcases.entity.TestCase;
import com.implementationbd.testcases.repository.ITestCaseRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseServiceImpl implements ITestCaseService {

    private final ITestCaseRepository repository;

    private final ObjectMapper mapper;

    public TestCaseServiceImpl(ITestCaseRepository repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
    }

    @Override
    public void save(TestCaseDto testCase) {
        TestCase newTest = mapper.convertValue(testCase, TestCase.class);
        repository.save(newTest);
    }

    @Override
    public List<TestCaseDto> getAll() {
        return repository.findAll()
                .stream()
                .map(test -> mapper.convertValue(test, TestCaseDto.class))
                .toList();
    }

    @Override
    public TestCaseDto getById(Long id) {
        return mapper.convertValue(repository.findById(id), TestCaseDto.class);
    }

    @Override
    public void update(long id, TestCaseDto testCase) {
        TestCase found = repository.findById(id).orElse(null);

        if (found != null) {
            found.setDescription(testCase.getDescription());
            found.setPassed(testCase.getPassed());
            found.setTested(testCase.getTested());
            found.setLastUpdate(testCase.getLastUpdate());
            found.setNumberOfTries(testCase.getNumberOfTries());

            repository.save(found);
        }
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<TestCaseDto> getTestCasesUpdatedAfterDate(LocalDate lastUpdate) {
        return null;
    }
}
