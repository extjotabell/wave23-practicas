package com.meli.obtenerdiploma.mock.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.apache.catalina.filters.RequestDumperFilter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Validación de cálculo de promedio y mensaje puede mejorar")
    void calculateAverageTestLessThan9() {
        StudentDTO studentWhen = new StudentDTO(1L,
                "Nico",
                null,
                null,
                new ArrayList<>() {{
                    add(new SubjectDTO("Lengua", 8.0));
                    add(new SubjectDTO("Informatica", 7.0));
                    add(new SubjectDTO("Gimnasia", 7.0));
                }}
        );

        when(studentDAO.findById(1L)).thenReturn(studentWhen);

        StudentDTO expectedResult = new StudentDTO(
                1L,
                "Nico",
                "El alumno Nico ha obtenido un promedio de 7.33. Puedes mejorar.",
                7.33,
                new ArrayList<>() {{
                    add(new SubjectDTO("Lengua", 8.0));
                    add(new SubjectDTO("Informatica", 7.0));
                    add(new SubjectDTO("Gimnasia", 7.0));
                }}
        );

        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        assertNotNull(result.getAverageScore());
        assertEquals(Math.round(expectedResult.getAverageScore()), Math.round(result.getAverageScore()));
        assertEquals(expectedResult.getMessage(), result.getMessage());
    }

    @Test
    @DisplayName("Validación de cálculo de promedio y mensaje feliciltaciones")
    void calculateAverageTestMoreThan9() {
        StudentDTO studentWhen = new StudentDTO(1L,
                "Nico",
                null,
                null,
                new ArrayList<>() {{
                    add(new SubjectDTO("Lengua", 10.0));
                    add(new SubjectDTO("Informatica", 9.0));
                    add(new SubjectDTO("Gimnasia", 9.0));
                }}
        );

        when(studentDAO.findById(1L)).thenReturn(studentWhen);

        StudentDTO expectedResult = new StudentDTO(
                1L,
                "Nico",
                "El alumno Nico ha obtenido un promedio de 9.33. Felicitaciones!",
                9.33,
                new ArrayList<>() {{
                    add(new SubjectDTO("Lengua", 10.0));
                    add(new SubjectDTO("Informatica", 9.0));
                    add(new SubjectDTO("Gimnasia", 9.0));
                }}
        );

        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        assertNotNull(result.getAverageScore());
        assertEquals(Math.round(expectedResult.getAverageScore()), Math.round(result.getAverageScore()));
        assertEquals(expectedResult.getMessage(), result.getMessage());
    }

    @Test
    @DisplayName("Validación de cálculo de promedio sin materias y mensaje")
    void calculateAverageNoSubjects() {
        StudentDTO studentWhen = new StudentDTO(1L,
                "Nico",
                null,
                null,
                new ArrayList<>()
        );

        when(studentDAO.findById(1L)).thenReturn(studentWhen);

        StudentDTO expectedResult = new StudentDTO(
                1L,
                "Nico",
                "El alumno Nico ha obtenido un promedio de NaN. Puedes mejorar.",
                0.0,
                new ArrayList<>()
        );

        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        assertNotNull(result.getAverageScore());
        assertEquals(Math.round(expectedResult.getAverageScore()), Math.round(result.getAverageScore()));
        assertEquals(expectedResult.getMessage(), result.getMessage());
    }



}
