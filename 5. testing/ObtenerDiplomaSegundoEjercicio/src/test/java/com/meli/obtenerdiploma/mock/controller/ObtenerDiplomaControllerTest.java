package com.meli.obtenerdiploma.mock.controller;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    ObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    @DisplayName("Analyze Score pass")
    void testAnalyzeScoresPass() {
        Long studentId = 1L;
        StudentDTO expectedResult = new StudentDTO(1L,
                "Nico",
                null,
                null,
                new ArrayList<>() {{
                    add(new SubjectDTO("Lengua", 8.0));
                    add(new SubjectDTO("Informatica", 7.0));
                    add(new SubjectDTO("Gimnasia", 7.0));
                }});
        when(obtenerDiplomaService.analyzeScores(studentId)).thenReturn(expectedResult);

        StudentDTO responseEntity = obtenerDiplomaController.analyzeScores(studentId);

        assertEquals(expectedResult, responseEntity);
        verify(obtenerDiplomaService,times(1)).analyzeScores(studentId);
    }
}
