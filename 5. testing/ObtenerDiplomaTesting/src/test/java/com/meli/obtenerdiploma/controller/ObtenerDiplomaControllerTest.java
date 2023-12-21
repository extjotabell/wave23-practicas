package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {
    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    @DisplayName("Analiza notas en controller")
    void analyzeScoresTest(){
        //Arrange
        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO subject1 = new SubjectDTO("Lengua", 6.0);
        subjects.add(subject1);
        StudentDTO student = new StudentDTO(1L, "Juan Perez", "mensaje", 8.0, subjects);

        //Act
        when(service.analyzeScores(any())).thenReturn(student);
        StudentDTO studentReturned = obtenerDiplomaController.analyzeScores(1L);

        //Assert
        verify(service, atLeastOnce()).analyzeScores(any());
        assertEquals(student, studentReturned);
    }
}
