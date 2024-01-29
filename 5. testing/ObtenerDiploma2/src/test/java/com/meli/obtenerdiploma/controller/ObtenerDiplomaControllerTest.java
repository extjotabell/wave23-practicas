package com.meli.obtenerdiploma.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    ObjectWriter writer = new ObjectMapper().
            configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();
    @Mock
    ObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;

    @DisplayName("Test de analyze score")
    @Test
    public void analyzeScores() throws JsonProcessingException {

        //ARRANGE
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática",9.5));
        subjectDTOList.add(new SubjectDTO("Física",9.5));
        subjectDTOList.add(new SubjectDTO("Química",9.5));
        StudentDTO test = new StudentDTO(1L,"Juan",null,null,subjectDTOList);

        test.setAverageScore(9.00);
        test.setMessage("El alumno Juan ha obtenido un promedio de 9.50. Felicitaciones!");

        //ACT
        Mockito.when(service.analyzeScores(test.getId())).thenReturn(test);
        StudentDTO obtain = controller.analyzeScores(test.getId());

        //ASSERT
        assertEquals(writer.writeValueAsString(test),writer.writeValueAsString(obtain));
    }
}