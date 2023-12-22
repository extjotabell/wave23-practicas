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
    void analyzeScoresCanBeBetter() {
        // Stub the findById method of the dao to return a test student with specific grades
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
        // Create the expected result based on the test student's grades
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

        // Call the analyzeScores method of the service with the student ID
        StudentDTO result = service.analyzeScores(1L);

        // Assert that the result's average score is not null
        assertNotNull(result.getAverageScore());
        // Assert that the result's average score is approximately equal to the expected average score
        assertEquals(Math.round(expectedResult.getAverageScore()), Math.round(result.getAverageScore()));
        // Assert that the result's message is equal to the expected message
        assertEquals(expectedResult.getMessage(), result.getMessage());
    }

    @Test
    @DisplayName("Score test analysis, average 9.33")
    void analyzeScoresCongratulations() {
        // Stub the findById method of the dao to return a test student with specific grades
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
        // Create the expected result based on the test student's grades
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

        // Call the analyzeScores method of the service with the student ID
        StudentDTO result = service.analyzeScores(2L);

        // Assert that the result's average score is not null
        assertNotNull(result.getAverageScore());
        // Assert that the result's average score is approximately equal to the expected average score
        assertEquals(Math.round(expectedResult.getAverageScore()), Math.round(result.getAverageScore()));
        // Assert that the result's message is equal to the expected message
        assertEquals(expectedResult.getMessage(), result.getMessage());
    }

    @Test
    @DisplayName("Score test analysis, null score")
    void analyzeScoresNullValue() {
        // Stub the findById method of the dao to return a test student with specific grades
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
        // Create the expected result based on the test student's grades
        StudentDTO expectedResult = new StudentDTO(
                2L,
                "Pedro",
                "El alumno Pedro ha obtenido un promedio de 9. Puedes mejorar.",
                9.0,
                new ArrayList<>(){{
                    add(new SubjectDTO("Matemática", null));
                    add(new SubjectDTO("Física", 9.0));
                    add(new SubjectDTO("Química", 9.0));
                }}
        );

        // Call the analyzeScores method of the service with the student ID
        StudentDTO result = service.analyzeScores(2L);

        // Assert that the result's average score is not null
        assertNotNull(result.getAverageScore());
        // Assert that the result's average score is approximately equal to the expected average score
        assertEquals(Math.round(expectedResult.getAverageScore()), Math.round(result.getAverageScore()));
        // Assert that the result's message is equal to the expected message
        assertEquals(expectedResult.getMessage(), result.getMessage());
    }

    @Test
    @DisplayName("Score test analysis, empty subject list")
    void analyzeScoresEmptySubjectList() {
        // Stub the findById method of the dao to return a test student with an empty subject list
        when(dao.findById(2L)).thenReturn(new StudentDTO(
                2L,
                "Pedro",
                null,
                null,
                new ArrayList<>()
        ));
        // Create the expected result based on the test student's empty subject list
        StudentDTO expectedResult = new StudentDTO(
                2L,
                "Pedro",
                "El alumno Pedro ha obtenido un promedio de 0. Puedes mejorar.",
                0.0,
                new ArrayList<>()
        );

        // Call the analyzeScores method of the service with the student ID
        StudentDTO result = service.analyzeScores(2L);

        // If the average score is not null, perform other assertions
        if (result.getAverageScore() != null) {
            // Assert that the result's average score is approximately equal to the expected average score
            assertEquals(Math.round(expectedResult.getAverageScore()), Math.round(result.getAverageScore()));
        }
        // Assert that the result's message is equal to the expected message
        assertEquals(expectedResult.getMessage(), result.getMessage());
    }


    @Test
    @DisplayName("Score test analysis, null name")
    void analyzeScoresNullName() {
        // Stub the findById method of the dao to return a test student with null name and specific grades
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
        // Create the expected result based on the test student's null name and grades
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

        // Call the analyzeScores method of the service with the student ID
        StudentDTO result = service.analyzeScores(1L);

        // Assert that the result's average score is not null
        assertNotNull(result.getAverageScore());
        // Assert that the result's average score is approximately equal to the expected average score
        assertEquals(Math.round(expectedResult.getAverageScore()), Math.round(result.getAverageScore()));
        // Assert that the result's message is equal to the expected message
        assertEquals(expectedResult.getMessage(), result.getMessage());
    }
}