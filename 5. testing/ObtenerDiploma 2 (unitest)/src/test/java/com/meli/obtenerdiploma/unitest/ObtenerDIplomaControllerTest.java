package com.meli.obtenerdiploma.unitest;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDIplomaControllerTest {

    @Mock
    private IObtenerDiplomaService service;

    @InjectMocks
    private ObtenerDiplomaController controller;

    @Test
    void analyzeScores_ReturnsStudentDTO() {
        // Arrange
        Long studentId = 1L;
        StudentDTO expectedStudentDTO = new StudentDTO(studentId, "John Doe", "message..", 90.0d, List.of(new SubjectDTO("Historia", 9.0)));

        when(service.analyzeScores(studentId)).thenReturn(expectedStudentDTO);

        // Act
        StudentDTO actualStudentDTO = controller.analyzeScores(studentId);

        // Assert
        assertEquals(expectedStudentDTO, actualStudentDTO);
    }

}
