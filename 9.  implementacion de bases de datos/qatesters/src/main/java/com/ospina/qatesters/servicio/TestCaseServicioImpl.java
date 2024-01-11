package com.ospina.qatesters.servicio;

import com.ospina.qatesters.excepcion.NotFoundException;
import com.ospina.qatesters.modelo.dto.request.TestCaseRequestDTO;
import com.ospina.qatesters.modelo.entidad.TestCase;
import com.ospina.qatesters.repositorio.TestCaseRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestCaseServicioImpl implements TestCaseServicio {

    private final TestCaseRepositorio testCaseRepositorio;

    public TestCaseServicioImpl(TestCaseRepositorio testCaseRepositorio) {
        this.testCaseRepositorio = testCaseRepositorio;
    }

    @Override
    @Transactional
    public TestCase obtenerTestCasePorId(Long id) {
        return testCaseRepositorio
                .findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontró un testCase con el id proporcionado: " + id));
    }

    @Override
    @Transactional
    public List<TestCase> obtenerTestCases(LocalDate lastUpdate) {
        if (lastUpdate == null) {
            return testCaseRepositorio.findAll();
        } else {
            return testCaseRepositorio.findAll().stream()
                    .filter(testCase -> testCase.getLastUpdate().isAfter(lastUpdate))
                    .collect(Collectors.toList());
        }
    }

    @Override
    @Transactional
    public Long guardarTestCase(TestCaseRequestDTO testCaseRequestDTO) {
        TestCase testCase = testCaseRepositorio.save(convertirTestCaseRequestDTOaTestCase(testCaseRequestDTO));
        return testCase.getIdCase();
    }

    @Override
    @Transactional
    public void borrarTestCase(Long id) {
        testCaseRepositorio.deleteById(id);
    }

    @Override
    @Transactional
    public TestCase actualizarTestCase(Long id, TestCaseRequestDTO testCaseRequestDTO) {
        TestCase testCase = testCaseRepositorio
                .findById(id)
                .orElseThrow(() -> new NotFoundException("No se encontró un testCase con el id proporcionado: " + id));
        testCase.setDescription(testCaseRequestDTO.getDescription());
        testCase.setTested(testCaseRequestDTO.getTested());
        testCase.setPassed(testCaseRequestDTO.getPassed());
        testCase.setNumberOfTries(testCaseRequestDTO.getNumberOfTries());
        testCase.setLastUpdate(testCaseRequestDTO.getLastUpdate());
        testCaseRepositorio.save(testCase);
        return testCase;
    }

    private TestCase convertirTestCaseRequestDTOaTestCase(TestCaseRequestDTO testCaseRequestDTO) {
        TestCase testCase = new TestCase();
        testCase.setDescription(testCaseRequestDTO.getDescription());
        testCase.setTested(testCaseRequestDTO.getTested());
        testCase.setPassed(testCaseRequestDTO.getPassed());
        testCase.setNumberOfTries(testCaseRequestDTO.getNumberOfTries());
        testCase.setLastUpdate(testCaseRequestDTO.getLastUpdate());
        return testCase;
    }

}
