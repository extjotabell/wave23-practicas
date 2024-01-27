package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ObtenerDiplomaControllerTest {

    @InjectMocks
    private ObtenerDiplomaController controller;

    @Mock
    private IObtenerDiplomaService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void analyzeScores_shouldReturnStudentDTO_whenStudentExists() {
        StudentDTO student = new StudentDTO();
        when(service.analyzeScores(1L)).thenReturn(student);
        StudentDTO result = controller.analyzeScores(1L);
        assertEquals(student, result);
    }

}