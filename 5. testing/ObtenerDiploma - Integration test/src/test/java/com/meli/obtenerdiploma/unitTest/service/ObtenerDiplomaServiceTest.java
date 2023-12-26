package com.meli.obtenerdiploma.unitTest.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    IStudentDAO iStudentDAO;
    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void analyzeScoresShouldCalculateAverageAndSetMessage() {
        //Arrange
        long studentId = 1L;
        StudentDTO studentDTO = new StudentDTO(studentId, "Juan", null, 0.0, List.of(
                new SubjectDTO("Matemáticas", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        ));

        //Act
        when(iStudentDAO.findById(studentId)).thenReturn(studentDTO);
        StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

        //Assert
        assertEquals(7.333333333333333, result.getAverageScore());
        assertEquals("El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.", result.getMessage());
    }
    @Test
    void analyzeScoresWithNoSubjects() {
        //Arrange
        long studentId = 1L;
        StudentDTO studentDTO = new StudentDTO(studentId, "Juan", "", 0.0, Collections.emptyList());

        //Act
        when(iStudentDAO.findById(studentId)).thenReturn(studentDTO);
        StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

        //Assert
        assertEquals(0.0, result.getAverageScore());
        assertEquals("El alumno Juan no tiene calificaciones.", result.getMessage());
    }
    @Test
    void analyzeScoresWithOneSubject() {
        //Arrange
        long studentId = 1L;
        StudentDTO studentDTO = new StudentDTO(studentId, "Juan", null, 0.0, List.of(new SubjectDTO("Matemáticas", 8.0)));

        //Act
        when(iStudentDAO.findById(studentId)).thenReturn(studentDTO);
        StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

        //Assert
        assertEquals(8.0, result.getAverageScore());
        assertEquals("El alumno Juan ha obtenido un promedio de 8. Puedes mejorar.", result.getMessage());
    }


}
