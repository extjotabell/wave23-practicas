package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTests {
    @Mock
    private IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    @DisplayName("ObtenerDiplomaController - obtenerDiploma: verificar que al menos un estudiante es devuelto")
    public void obtenerDiploma() {
        // Arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Fernando");
        // Act
        obtenerDiplomaController.analyzeScores(stu.getId());

        // Assert
        verify(obtenerDiplomaService, atLeastOnce()).analyzeScores(stu.getId());
    }



}
