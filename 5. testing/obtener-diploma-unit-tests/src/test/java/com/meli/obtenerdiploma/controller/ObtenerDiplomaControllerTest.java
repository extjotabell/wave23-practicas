package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {

    @Mock
    ObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;
    StudentDTO studentDTO;

    @BeforeEach
    void initialize() {
        studentDTO = new StudentDTO(
                1L,
                "Juan",
                null,
                null,
                new ArrayList<>() {{
                    add(new SubjectDTO("Matemática", 9.0));
                    add(new SubjectDTO("Física", 7.0));
                    add(new SubjectDTO("Química", 6.0));
                }}
        );
    }

    @Test
    @DisplayName("Test analyze scores successfully")
    void analyzeScoresOk() {
        Long param = 1L;
        StudentDTO expectedResult = studentDTO;

        when(service.analyzeScores(param)).thenReturn(expectedResult);
        StudentDTO result = controller.analyzeScores(param);

        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Test analyze scores with non-existent student id")
    void analyzeScoresWithNonExistentId() {
        Long param = 99L;

        when(service.analyzeScores(param)).thenThrow(new StudentNotFoundException(param));
        assertThrows(StudentNotFoundException.class,
                () -> controller.analyzeScores(param)
        );
    }
}