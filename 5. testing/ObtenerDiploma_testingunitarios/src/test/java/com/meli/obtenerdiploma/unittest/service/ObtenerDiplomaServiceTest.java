package com.meli.obtenerdiploma.unittest.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService service;

    @Test
    @DisplayName("Test AnalyzeScore - OK")
    void testAnalyzeScore_OK(){
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Matematica", 8.0),
                new SubjectDTO("Fisica", 8.0)
        );
        StudentDTO student = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de 8.0. Puedes mejorar", 8.0, subjects);
        Double expectedAverage = 8.0;

        when(studentDAO.findById(anyLong())).thenReturn(student);

        StudentDTO studentActual = service.analyzeScores(1L);
        verify(studentDAO, atLeastOnce()).findById(anyLong());
        assertEquals(expectedAverage, studentActual.getAverageScore());
    }

    @Test
    @DisplayName("Test AnalyzeScore - StudentNotFoundException")
    void testAnalyzeScore_ThrowsStudentNotFoundException(){
        when(studentDAO.findById(anyLong())).thenThrow(StudentNotFoundException.class);

        assertThrows(StudentNotFoundException.class, () -> service.analyzeScores(99L));
    }
}
