package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @InjectMocks
    private ObtenerDiplomaService service;

    @Mock
    private IStudentDAO studentDAO;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void analyzeScores_shouldCalculateAverageAndReturnGreetingMessage() {
        // Arrange
        StudentDTO student = new StudentDTO();
        student.setSubjects(Arrays.asList(new SubjectDTO("Matemática", 9.0), new SubjectDTO("Física", 7.0), new SubjectDTO("Química", 6.0)));
        when(studentDAO.findById(1L)).thenReturn(student);

        // Act
        StudentDTO result = service.analyzeScores(1L);

        // Assert
        assertEquals(7.333333333333333, result.getAverageScore());
        assertEquals("El alumno null ha obtenido un promedio de 7.33. Puedes mejorar.", result.getMessage());
    }

    @Test
    void analyzeScores_shouldHandleASubjectWithZeroList() {
        // Arrange
        StudentDTO student = new StudentDTO();
        student.setSubjects(List.of(new SubjectDTO("Matemática", 0.0)));
        when(studentDAO.findById(1L)).thenReturn(student);

        // Act
        StudentDTO result = service.analyzeScores(1L);

        // Assert
        assertEquals(0.0, result.getAverageScore());
        assertEquals("El alumno null ha obtenido un promedio de 0. Puedes mejorar.", result.getMessage());
    }
}