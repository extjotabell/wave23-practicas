package com.meli.obtenerdiploma.unitTest.controller;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.DisplayName;
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
    private IObtenerDiplomaService service;
    @InjectMocks
    ObtenerDiplomaController controller;

    @Test
    @DisplayName("ok")
    void analyzeScores(){
        //Arr
        StudentDTO studentExpected = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.", 0.0, List.of(
                new SubjectDTO("Matemáticas", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        ));
        //Act
        when(service.analyzeScores(1L)).thenReturn(studentExpected);
        StudentDTO actual = controller.analyzeScores(1L);
        //Assert
        assertEquals(studentExpected,actual);
    }
    @Test
    @DisplayName("not found")
    void analyzeScoresNotFound(){
        //Arr
        StudentDTO studentExpected = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.", 0.0, List.of(
                new SubjectDTO("Matemáticas", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        ));
        //Act
        when(service.analyzeScores(1000L)).thenReturn(studentExpected);
        //Assert
        assertThrows(RuntimeException.class,()->controller.analyzeScores(1L));
    }

}
