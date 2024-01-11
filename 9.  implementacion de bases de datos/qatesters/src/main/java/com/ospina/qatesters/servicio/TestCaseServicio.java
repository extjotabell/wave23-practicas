package com.ospina.qatesters.servicio;

import com.ospina.qatesters.modelo.dto.request.TestCaseRequestDTO;
import com.ospina.qatesters.modelo.entidad.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface TestCaseServicio {

    List<TestCase> obtenerTestCases();

    TestCase obtenerTestCasePorId(Long id);

    List<TestCase> obtenerTestCaseDespuesDeFecha(LocalDate fecha);

    Long guardarTestCase(TestCaseRequestDTO testCaseRequestDTO);

    void borrarTestCase(Long id);

    TestCase actualizarTestCase(Long id, TestCaseRequestDTO testCaseRequestDTO);
}
