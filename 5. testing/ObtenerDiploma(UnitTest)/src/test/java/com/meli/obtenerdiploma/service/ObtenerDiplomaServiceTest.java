package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService service;


    @DisplayName("average score well calculated")
    @Test
    public void calculateAverageOKTest(){
        // arrange
        StudentDTO student = new StudentDTO();
        student.setSubjects(Arrays.asList(new SubjectDTO("Matemática", 9.0), new SubjectDTO("Física", 7.0), new SubjectDTO("Química", 6.0)));
        when(studentDAO.findById(1L)).thenReturn(student);

        // act
        StudentDTO result = service.analyzeScores(1L);

        // assert
        assertEquals(7.333333333333333, result.getAverageScore());
        verify(studentDAO, atLeastOnce()).findById(1L);
    }

    @DisplayName("average score bellow 9 message well written")
    @Test
    public void averageScoreBellow9MessageWellWritten(){
        // arrange
        StudentDTO student = new StudentDTO();
        student.setSubjects(Arrays.asList(new SubjectDTO("Matemática", 9.0), new SubjectDTO("Física", 7.0), new SubjectDTO("Química", 6.0)));
        when(studentDAO.findById(1L)).thenReturn(student);

        // act
        StudentDTO result = service.analyzeScores(1L);

        // assert
        assertEquals("El alumno null ha obtenido un promedio de 7.33. Puedes mejorar.", result.getMessage());
    }

    @DisplayName("average score over 9 message well written")
    @Test
    public void averageScoreOver9MessageWellWritten(){
        // arrange
        StudentDTO student = new StudentDTO();
        student.setSubjects(Arrays.asList(new SubjectDTO("Matemática", 10.0), new SubjectDTO("Física", 10.0), new SubjectDTO("Química", 10.0)));
        when(studentDAO.findById(1L)).thenReturn(student);

        // act
        StudentDTO result = service.analyzeScores(1L);

        // assert
        assertEquals("El alumno null ha obtenido un promedio de 10. Felicitaciones!", result.getMessage());
    }

    @DisplayName("student name matches response student name")
    @Test
    public void studenNameTest(){
        // arrange
        StudentDTO student = new StudentDTO();
        student.setStudentName("Claudia");
        student.setSubjects(Arrays.asList(new SubjectDTO("Matemática", 10.0), new SubjectDTO("Física", 10.0), new SubjectDTO("Química", 10.0)));
        when(studentDAO.findById(1L)).thenReturn(student);

        // Act
        StudentDTO result = service.analyzeScores(1L);

        // Assert
        assertEquals("Claudia", result.getStudentName());
    }
}
