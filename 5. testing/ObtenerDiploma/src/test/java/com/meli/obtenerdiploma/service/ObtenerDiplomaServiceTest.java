package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {
    @Mock
    private IStudentDAO studentDAO;
    @InjectMocks
    private ObtenerDiplomaService service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAnalyzeScoresWithValidData() {
        StudentDTO mockStudent = new StudentDTO();
        mockStudent.setStudentName("Test Student");
        mockStudent.setSubjects(Arrays.asList(
                new SubjectDTO("Math", 8.0),
                new SubjectDTO("Science", 9.0)));

        when(studentDAO.findById(1L)).thenReturn(mockStudent);

        StudentDTO result = service.analyzeScores(1L);

        assertNotNull(result);
        assertEquals("Test Student", result.getStudentName());
        assertEquals(8.5, result.getAverageScore());
        assertTrue(result.getMessage().contains("Test Student"));
    }

    @Test
    void testAnalyzeScoresWithHonors() {
        StudentDTO mockStudent = new StudentDTO();
        mockStudent.setStudentName("Honor Student");
        mockStudent.setSubjects(Arrays.asList(
                new SubjectDTO("Math", 9.5),
                new SubjectDTO("Science", 10.0)));

        when(studentDAO.findById(2L)).thenReturn(mockStudent);

        StudentDTO result = service.analyzeScores(2L);

        assertNotNull(result);
        assertTrue(result.getMessage().contains("Felicitaciones"));
    }

    @Test
    void testAnalyzeScoresWithEmptySubjects() {
        StudentDTO mockStudent = new StudentDTO();
        mockStudent.setStudentName("Empty Subject Student");
        mockStudent.setSubjects(List.of());

        when(studentDAO.findById(3L)).thenReturn(mockStudent);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.analyzeScores(3L);
        });

        String expectedMessage = "No subjects available for analysis";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testAnalyzeScoresWithNullStudent() {
        when(studentDAO.findById(4L)).thenReturn(null);

        Exception exception = assertThrows(StudentNotFoundException.class, () -> {
            service.analyzeScores(4L);
        });

        assertNotNull(exception);
    }

    @Test
    void testAnalyzeScoresWithHighAverage() {
        StudentDTO mockStudent = new StudentDTO(1L, "Student High", "", 0.0,
                Arrays.asList(new SubjectDTO("Math", 9.5), new SubjectDTO("Science", 10.0)));

        when(studentDAO.findById(1L)).thenReturn(mockStudent);

        StudentDTO result = service.analyzeScores(1L);

        assertNotNull(result);
        assertEquals(9.75, result.getAverageScore());
        assertTrue(result.getMessage().contains("Felicitaciones"));
    }

    @Test
    void testAnalyzeScoresWithLowAverage() {
        StudentDTO mockStudent = new StudentDTO(2L, "Student Low", "", 0.0,
                Arrays.asList(new SubjectDTO("Math", 6.0), new SubjectDTO("Science", 5.5)));

        when(studentDAO.findById(2L)).thenReturn(mockStudent);

        StudentDTO result = service.analyzeScores(2L);

        assertNotNull(result);
        assertEquals(5.75, result.getAverageScore());
        assertTrue(result.getMessage().contains("Puedes mejorar"));
    }
}
