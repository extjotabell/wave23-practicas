package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

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
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        when(studentDAO.findById(1L)).thenReturn(student);

        // Act
        StudentDTO result = service.analyzeScores(1L);

        // Assert
        assertEquals(6.0, result.getAverageScore());
        assertEquals("El alumno Marco ha obtenido un promedio de 6. Puedes mejorar.", result.getMessage());
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

    @Test
    void averageScoreOver9MessageWellWritten() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Marco");
        when(studentDAO.findById(stu.getId())).thenReturn(stu);

        // act
        service.analyzeScores(stu.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(stu.getId());
        assertEquals("El alumno Marco ha obtenido un promedio de 9.00. Felicitaciones!", stu.getMessage());
    }

    @Test
    void averageScoreBelow9MessageWellWritten() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        when(studentDAO.findById(stu.getId())).thenReturn(stu);

        // act
        service.analyzeScores(stu.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(stu.getId());
        assertEquals("El alumno Marco ha obtenido un promedio de 6.00. Puedes mejorar.", stu.getMessage());
    }

    @Test
    void RequestStudentNameMatchesResponseStudentName() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        when(studentDAO.findById(stu.getId())).thenReturn(stu);

        // act
        service.analyzeScores(stu.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(stu.getId());
        assertEquals("Marco", stu.getStudentName());
    }
}