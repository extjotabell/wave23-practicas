package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    @DisplayName("Analyze score given the id ")
    void analyceScore(){
        //Arrange
        StudentDTO studentDTOExpected = new StudentDTO();
        when(obtenerDiplomaService.analyzeScores(anyLong())).thenReturn(studentDTOExpected);

        //Act
        StudentDTO result = obtenerDiplomaController.analyzeScores(1L);

        //Assert
        assertEquals(studentDTOExpected, result);
    }
}
