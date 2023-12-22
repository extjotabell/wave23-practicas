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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    IStudentDAO studentDAO;
    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;


    @Test
    @DisplayName("Datos de salida identicos a entrada")
    void analyzeScoresDataTest(){
        //Arrange
        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO subject1 = new SubjectDTO("Lengua", 6.0);
        SubjectDTO subject2 = new SubjectDTO("Matematica", 8.0);
        subjects.add(subject1);
        subjects.add(subject2);
        StudentDTO student = new StudentDTO(1L, "Juan Perez", "mensaje", 8.0, subjects);

        //Act
        when(studentDAO.findById(any())).thenReturn(student);
        StudentDTO studentReturn = obtenerDiplomaService.analyzeScores(1L);

        //Assert
        assertEquals(1L, student.getId());
        assertEquals("Juan Perez", student.getStudentName());
        assertEquals(7.0, student.getAverageScore());
        assertEquals(subjects, student.getSubjects());
    }



    @Test
    @DisplayName("Analiza notas")
    void analyzeScoresTest(){
        //Arrange
        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO subject1 = new SubjectDTO("Lengua", 6.0);
        SubjectDTO subject2 = new SubjectDTO("Matematica", 8.0);
        subjects.add(subject1);
        subjects.add(subject2);
        StudentDTO student = new StudentDTO(1L, "Juan Perez", "mensaje", 8.0, subjects);
        Double expectedAverage = 7.0;

        //Act
        when(studentDAO.findById(any())).thenReturn(student);
        StudentDTO studentReturned = obtenerDiplomaService.analyzeScores(1L);


        //Assert
        verify(studentDAO, atLeast(1)).findById(any());
        assertEquals(expectedAverage, studentReturned.getAverageScore());
    }

}
