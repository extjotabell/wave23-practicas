package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    @DisplayName("Test to verify the return of a student")
    void analyzeScoresTest() {
        // Arrange
        Long studentId = 1L;
        StudentDTO expectedStudent = new StudentDTO();
        Mockito.when(obtenerDiplomaService.analyzeScores(studentId)).thenReturn(expectedStudent);

        // Act
        StudentDTO actualStudent = obtenerDiplomaController.analyzeScores(studentId);

        // Assert
        assertEquals(expectedStudent, actualStudent);
        Mockito.verify(obtenerDiplomaService, Mockito.times(1)).analyzeScores(studentId);
    }
}
