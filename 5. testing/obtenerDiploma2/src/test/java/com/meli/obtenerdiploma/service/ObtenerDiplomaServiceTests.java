package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTests {
    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Analyze data OK")
    void analyzeDataOK() {
        // Arrange
        StudentDTO student = new StudentDTO(
            1L,
            "John Doe",
            "Test message",
            5.0,
            new ArrayList<>(List.of(
                new SubjectDTO("Math", 10.0),
                new SubjectDTO("History", 10.0),
                new SubjectDTO("Geography", 10.0)
            ))
        );

        // Act
        Mockito.when(studentDAO.findById(student.getId())).thenReturn(student);
        StudentDTO studentFound = obtenerDiplomaService.analyzeScores(student.getId());

        // Assert
        Assertions.assertEquals(student, studentFound);
        Assertions.assertEquals(10.0, studentFound.getAverageScore());
    }
}
