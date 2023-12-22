package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;

import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    StudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Test to null case")
    public void testNullCaseTest() {
        //Arrange
        Long studentId = null;
        when(studentDAO.findById(null)).thenReturn(null); // Changed this line

        //Act and Assert
        assertThrows(NullPointerException.class, () -> obtenerDiplomaService.analyzeScores(studentId));
    }

    @Test
    @DisplayName("Test for same data input and output")
    public void testIdenticalOutputToInputTest() {
        //Arrange
        StudentDTO student = new StudentDTO();
        student.setSubjects(Arrays.asList(new SubjectDTO("Math", 10.0), new SubjectDTO("Science", 8.0)));
        when(studentDAO.findById(anyLong())).thenReturn(student);

        //Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        //Assert
        assertEquals(student.getSubjects(), result.getSubjects());
    }

    @Test
    @DisplayName("Test for average calculation")
    public void testAverageCalculationTest() {
        //Arrange
        StudentDTO student = new StudentDTO();
        student.setSubjects(Arrays.asList(new SubjectDTO("Math", 10.0), new SubjectDTO("Science", 8.0)));
        when(studentDAO.findById(anyLong())).thenReturn(student);

        //Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        //Assert
        assertEquals(9.0, result.getAverageScore());
    }

    @Test
    @DisplayName("Test for diploma message")
    public void testDiplomaMessageTest() {
        //Arrange
        StudentDTO student = new StudentDTO();
        student.setSubjects(Arrays.asList(new SubjectDTO("Matemática", 9.0), new SubjectDTO("Science", 9.0)));
        when(studentDAO.findById(anyLong())).thenReturn(student);

        //Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        //Assert
        assertEquals(9, result.getAverageScore());
        assertEquals("El alumno null ha obtenido un promedio de 9. Puedes mejorar.", result.getMessage());
    }

    @Test
    @DisplayName("Test for diploma with honors message")
    public void testDiplomaWithHonorsMessageTest() {
        //Arrange
        StudentDTO student = new StudentDTO();
        student.setSubjects(Arrays.asList(new SubjectDTO("Math", 10.0), new SubjectDTO("Science", 10.0)));
        when(studentDAO.findById(anyLong())).thenReturn(student);

        //Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        //Assert
        assertEquals(String.format("El alumno %s ha obtenido un promedio de %.0f. Felicitaciones!", student.getStudentName(), 10.00), result.getMessage());    }
}
