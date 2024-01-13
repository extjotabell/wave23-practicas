package com.ejercicio.QATester.service;

import com.ejercicio.QATester.dto.TestCaseDTO;
import com.ejercicio.QATester.model.TestCase;
import com.ejercicio.QATester.repository.ITestCaseRepository;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCaseServiceImpl implements ITestCaseService {
    private ITestCaseRepository testCaseRepository;

    public TestCaseServiceImpl(ITestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    @Override
    public TestCaseDTO createTestCase(TestCaseDTO testCaseDTO) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        return mapper.convertValue(testCaseRepository.save(mapper.convertValue(testCaseDTO, TestCase.class)), TestCaseDTO.class);
    }

    @Override
    public TestCaseDTO updateTestCase(TestCaseDTO testCaseDTO, Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser null");
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        TestCase existingTestCase = testCaseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TestCase no encontrado con ID: " + id));

        try {
            mapper.updateValue(existingTestCase, testCaseDTO);
        } catch (JsonMappingException e) {
            throw new RuntimeException("Error al mapear DTO a la entidad: " + e.getMessage());
        }

        TestCase updatedTestCase = testCaseRepository.save(existingTestCase);

        return mapper.convertValue(updatedTestCase, TestCaseDTO.class);
    }

    @Override
    public void deleteTestCase(Long id) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        testCaseRepository.deleteById(id);
    }

    @Override
    public TestCaseDTO getTestCaseById(Long id) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        TestCase testCase = testCaseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TestCase no encontrado con ID: " + id));

        return mapper.convertValue(testCase, TestCaseDTO.class);
    }

    @Override
    public List<TestCaseDTO> getAllTestCases() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        List<TestCase> testCases = testCaseRepository.findAll();

        return testCases.stream()
                .map(testCase -> mapper.convertValue(testCase, TestCaseDTO.class))
                .toList();
    }

    @Override
    public List<TestCaseDTO> getTestCasesByDate(String date) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        LocalDate localDate = LocalDate.parse(date);

        List<TestCase> testCases = testCaseRepository.findTestCasesByDate(localDate);

        return testCases.stream()
                .map(testCase -> mapper.convertValue(testCase, TestCaseDTO.class))
                .toList();
    }
}
