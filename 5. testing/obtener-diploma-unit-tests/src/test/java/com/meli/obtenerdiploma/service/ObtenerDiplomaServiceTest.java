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

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {
    @Mock
    StudentDAO dao;

    @InjectMocks
    ObtenerDiplomaService service;

    @Test
    @DisplayName("Test analyze scores for student with 8.0 average")
    void analyzeScoresAverage8() {
        Long param = 1L;
        StudentDTO expectedResult = generateStudentWithAverage(8.0);

        when(dao.findById(param)).thenReturn(expectedResult);
        StudentDTO result = service.analyzeScores(param);

        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Test analyze scores for student with 9.33 average")
    void analyzeScoresAverageGreaterThan9() {
        Long param = 1L;
        StudentDTO expectedResult = generateStudentWithAverage(9.33);

        when(dao.findById(param)).thenReturn(expectedResult);
        StudentDTO result = service.analyzeScores(param);

        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Test analyze scores for student with null score")
    void analyzeScoresNullValue() {
        Long param = 1L;
        StudentDTO expectedResult = generateStudentWithAverage(null);

        when(dao.findById(param)).thenReturn(expectedResult);
        assertThrows(NullPointerException.class,
                () -> service.analyzeScores(param));
    }

    @Test
    @DisplayName("Test analyze scores for student with empty subject list")
    void analyzeScoresEmptySubjectList() {
        Long param = 1L;
        StudentDTO expectedStudent = new StudentDTO(
                1L,
                "Pedro",
                null,
                null,
                new ArrayList<>()
        );
        Double expectedResult = Double.NaN;

        when(dao.findById(param)).thenReturn(expectedStudent);
        StudentDTO result = service.analyzeScores(param);

        assertEquals(expectedResult, result.getAverageScore());
    }

    private StudentDTO generateStudentWithAverage(Double average) {
        return new StudentDTO(
                1L,
                "Juan",
                null,
                average,
                new ArrayList<>() {{
                    add(new SubjectDTO("Matemática", average));
                    add(new SubjectDTO("Física", average));
                    add(new SubjectDTO("Química", average));
                }}
        );
    }
}