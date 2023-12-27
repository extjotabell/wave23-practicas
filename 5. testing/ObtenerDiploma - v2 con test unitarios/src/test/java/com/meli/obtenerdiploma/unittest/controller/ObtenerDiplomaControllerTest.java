package com.meli.obtenerdiploma.unittest.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {
    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaControllerTest controller;

    @Test
    void analyzeScoresTest() {
        // Arrange
        StudentDTO expected = new StudentDTO();
        expected.setStudentName("Marcos");
        expected.setSubjects(List.of(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Química", 10.0),
                new SubjectDTO("Física", 10.0)
        ));
        when(service.analyzeScores(expected.getId())).thenReturn(expected);

        // Act
        StudentDTO obtained = service.analyzeScores(expected.getId());

        // Assert
        assertEquals(expected.getAverageScore(), obtained.getAverageScore());
    }

    @Test
    void analyzeScoresSadTest() {
        // Arrange
        StudentDTO expected = new StudentDTO();
        expected.setId(-30L);
        expected.setStudentName("Pepe");
        //when(service.analyzeScores(expected.getId())).thenReturn(expected);

        // Act & Assert
        assertThrows(NullPointerException.class, () -> service.analyzeScores(expected.getId()).getAverageScore());
    }
}
