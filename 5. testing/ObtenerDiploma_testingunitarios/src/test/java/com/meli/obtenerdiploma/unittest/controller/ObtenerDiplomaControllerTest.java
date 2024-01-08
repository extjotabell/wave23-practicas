package com.meli.obtenerdiploma.unittest.controller;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.BeforeEach;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;

    List<SubjectDTO> subjects;
    StudentDTO student;

    @BeforeEach
    void setUp(){
        subjects = List.of(
                new SubjectDTO("Matematica", 8.0),
                new SubjectDTO("Fisica", 8.0)
        );

        student = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de 8.0. Puedes mejorar", 8.0, subjects);
    }

    @Test
    @DisplayName("Test Analyze Scores - OK")
    void testAnalyzeScores_OK(){
        when(service.analyzeScores(anyLong())).thenReturn(student);

        StudentDTO actual = controller.analyzeScores(1L);

        assertEquals(student.getAverageScore(), actual.getAverageScore());
    }

    @Test
    @DisplayName("Test Analyze Scores - StudentNotFoundException")
    void testAnalyzeScores_ThrowsStudentNotFoundException(){
        when(service.analyzeScores(anyLong())).thenThrow(StudentNotFoundException.class);
        assertThrows(StudentNotFoundException.class, () -> controller.analyzeScores(99L));
    }

}
