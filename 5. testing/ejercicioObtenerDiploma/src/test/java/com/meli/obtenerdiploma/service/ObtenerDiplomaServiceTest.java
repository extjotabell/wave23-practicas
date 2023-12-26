package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {
    @Mock
    StudentDAO dao;

    @InjectMocks
    ObtenerDiplomaService service;

    @Test
    @DisplayName("Score test analysis, average 8.0")
    void analyzeScoresPuedeMejorar() {
        when(dao.findById(1L)).thenReturn(new StudentDTO(
                1L,
                "Juan",
                null,
                null,
                new ArrayList<>(){{
                    add(new SubjectDTO("Matemática", 9.0));
                    add(new SubjectDTO("Física", 7.0));
                    add(new SubjectDTO("Química", 6.0));
                }}
        ));
        StudentDTO expectedResult = new StudentDTO(
                1L,
                "Juan",
                "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.",
                7.33,
                new ArrayList<>(){{
                    add(new SubjectDTO("Matemática", 9.0));
                    add(new SubjectDTO("Física", 7.0));
                    add(new SubjectDTO("Química", 6.0));
                }}
        );

        StudentDTO result = service.analyzeScores(1L);

        assertNotNull(result.getAverageScore());
        assertEquals(Math.round(expectedResult.getAverageScore()), Math.round(result.getAverageScore()));
        assertEquals(expectedResult.getMessage(), result.getMessage());
    }

    @Test
    @DisplayName("Score test analysis, average 9.33")
    void analyzeScoresFelicitaciones() {
        when(dao.findById(2L)).thenReturn(new StudentDTO(
                2L,
                "Pedro",
                null,
                null,
                new ArrayList<>(){{
                    add(new SubjectDTO("Matemática", 10.0));
                    add(new SubjectDTO("Física", 9.0));
                    add(new SubjectDTO("Química", 9.0));
                }}
        ));
        StudentDTO expectedResult = new StudentDTO(
                2L,
                "Pedro",
                "El alumno Pedro ha obtenido un promedio de 9.33. Felicitaciones!",
                9.0,
                new ArrayList<>(){{
                    add(new SubjectDTO("Matemática", 10.0));
                    add(new SubjectDTO("Física", 9.0));
                    add(new SubjectDTO("Química", 9.0));
                }}
        );

        StudentDTO result = service.analyzeScores(2L);

        assertNotNull(result.getAverageScore());
        assertEquals(Math.round(expectedResult.getAverageScore()), Math.round(result.getAverageScore()));
        assertEquals(expectedResult.getMessage(), result.getMessage());
    }

    @Test
    @DisplayName("Score test analysis, null score")
    void analyzeScoresNullValue() {
        when(dao.findById(2L)).thenReturn(new StudentDTO(
                2L,
                "Pedro",
                null,
                null,
                new ArrayList<>(){{
                    add(new SubjectDTO("Matemática", null));
                    add(new SubjectDTO("Física", 9.0));
                    add(new SubjectDTO("Química", 9.0));
                }}
        ));
        StudentDTO expectedResult = new StudentDTO(
                2L,
                "Pedro",
                "El alumno Pedro ha obtenido un promedio de 9.00. Puedes mejorar.",
                9.0,
                new ArrayList<>(){{
                    add(new SubjectDTO("Matemática", null));
                    add(new SubjectDTO("Física", 9.0));
                    add(new SubjectDTO("Química", 9.0));
                }}
        );

        StudentDTO result = service.analyzeScores(2L);

        assertNotNull(result.getAverageScore());
        assertEquals(Math.round(expectedResult.getAverageScore()), Math.round(result.getAverageScore()));
        assertEquals(expectedResult.getMessage(), result.getMessage());
    }

    @Test
    @DisplayName("Score test analysis, empty subject list")
    void analyzeScoresEmptySubjectList() {
        when(dao.findById(2L)).thenReturn(new StudentDTO(
                2L,
                "Pedro",
                null,
                null,
                new ArrayList<>()
        ));
        StudentDTO expectedResult = new StudentDTO(
                2L,
                "Pedro",
                "El alumno Pedro ha obtenido un promedio de 0.00. Puedes mejorar.",
                0.0,
                new ArrayList<>()
        );

        StudentDTO result = service.analyzeScores(2L);

        assertNotNull(result.getAverageScore());
        assertEquals(Math.round(expectedResult.getAverageScore()), Math.round(result.getAverageScore()));
        assertEquals(expectedResult.getMessage(), result.getMessage());
    }

    @Test
    @DisplayName("Score test analysis, null name")
    void analyzeScoresNullName() {
        when(dao.findById(1L)).thenReturn(new StudentDTO(
                1L,
                null,
                null,
                null,
                new ArrayList<>(){{
                    add(new SubjectDTO("Matemática", 9.0));
                    add(new SubjectDTO("Física", 7.0));
                    add(new SubjectDTO("Química", 6.0));
                }}
        ));
        StudentDTO expectedResult = new StudentDTO(
                1L,
                null,
                "El alumno null ha obtenido un promedio de 7.33. Puedes mejorar.",
                7.33,
                new ArrayList<>(){{
                    add(new SubjectDTO("Matemática", 9.0));
                    add(new SubjectDTO("Física", 7.0));
                    add(new SubjectDTO("Química", 6.0));
                }}
        );

        StudentDTO result = service.analyzeScores(1L);

        assertNotNull(result.getAverageScore());
        assertEquals(Math.round(expectedResult.getAverageScore()), Math.round(result.getAverageScore()));
        assertEquals(expectedResult.getMessage(), result.getMessage());
    }
}