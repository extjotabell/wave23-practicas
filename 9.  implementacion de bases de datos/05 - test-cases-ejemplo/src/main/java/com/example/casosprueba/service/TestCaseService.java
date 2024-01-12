package com.example.casosprueba.service;

import com.example.casosprueba.dto.TestCaseDTO;
import com.example.casosprueba.model.TestCase;
import com.example.casosprueba.repository.ITestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;

@Service
public class TestCaseService implements  ITestCaseService{

    @Autowired
    ITestCaseRepository testCaseRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public TestCaseDTO addTestCase(TestCaseDTO dto) {
        TestCase sale = modelMapper.map(dto, TestCase.class);
        return modelMapper.map(testCaseRepository.save(sale), TestCaseDTO.class);
    }

    @Override
    public List<TestCaseDTO> getAllTestCases() {
        List<TestCase> testCases = testCaseRepository.findAll();
        return testCases.stream().map(sale -> modelMapper.map(sale, TestCaseDTO.class)).toList();
    }

    @Override
    public TestCaseDTO getTestCase(long id) {
        TestCase testCase = testCaseRepository.findById(id).orElse(null);
        if (testCase == null) {
            throw new RuntimeException("No existe el caso de prueba con id: " + id);
        }
        return modelMapper.map(testCase, TestCaseDTO.class);
    }

    @Override
    public TestCaseDTO updateTestCase(long id, TestCaseDTO dto) {
        TestCase foundTestCase = testCaseRepository.findById(id).orElse(null);
        if (foundTestCase == null) {
            throw new RuntimeException("No existe el caso de prueba con id: " + id);
        }
        dto.setId(foundTestCase.getId());
        TestCase saleToUpdate = modelMapper.map(dto, TestCase.class);

        return modelMapper.map(testCaseRepository.save(saleToUpdate), TestCaseDTO.class);
    }

    @Override
    public TestCaseDTO deleteTestCase(long number) {
        TestCase foundTestCase = testCaseRepository.findById(number).orElse(null);
        if (foundTestCase == null) {
            throw new RuntimeException("No existe el caso de prueba con id: " + number);
        }
        TestCaseDTO testCaseDeleted = modelMapper.map(foundTestCase, TestCaseDTO.class);
        testCaseRepository.deleteById(number);
        return testCaseDeleted;
    }


    @Override
    public List<TestCaseDTO> getAllTestCasesAfterUpdateDate(LocalDate date) {
        return testCaseRepository.findAllByLastUpdateIsAfter(date).stream().map(testCase -> modelMapper.map(testCase, TestCaseDTO.class)).toList();
    }


}
