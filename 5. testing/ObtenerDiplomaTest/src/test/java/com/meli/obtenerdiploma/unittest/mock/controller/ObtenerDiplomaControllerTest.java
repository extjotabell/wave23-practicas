package com.meli.obtenerdiploma.unittest.mock.controller;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {
    @Mock
    private IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    private ObtenerDiplomaController obtenerDiplomaController;

    @Test
    @DisplayName("ObtenerDiplomadoController - analyzeScores: Null pointer exception")
    void analizarScoresSameIdTest(){
        // Arrange - Act
        Mockito.when(obtenerDiplomaService.analyzeScores(null))
                .thenThrow(new NullPointerException());
        // Assert
        Assertions.assertThrows(NullPointerException.class, () -> obtenerDiplomaController.analyzeScores(null));
    }
}
