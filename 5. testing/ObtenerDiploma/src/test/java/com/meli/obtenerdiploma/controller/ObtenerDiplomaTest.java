package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaTest {
    @Mock
    IObtenerDiplomaService service;
    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void analyzeScores_whenStudenExist() {
        StudentDTO student = new StudentDTO();
        when(service.analyzeScores(1L)).thenReturn(student);
        StudentDTO result = obtenerDiplomaController.analyzeScores(1L);
        assertEquals(student, result);
    }
}
