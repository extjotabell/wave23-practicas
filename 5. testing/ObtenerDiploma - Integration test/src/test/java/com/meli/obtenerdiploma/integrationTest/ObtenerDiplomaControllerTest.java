package com.meli.obtenerdiploma.integrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("analyze score ok")
    void analyzeScoresOk() throws Exception {
        StudentDTO expected = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.", 7.333333333333333, List.of(
                new SubjectDTO("Matematicas", 9.0),
                new SubjectDTO("Fisica", 7.0),
                new SubjectDTO("Quimica", 6.0)
        ));

        ObjectWriter objecTWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String responseJson = objecTWriter.writeValueAsString(expected);


       MvcResult mvcResult = mockMvc.perform(get("/analyzeScores/{studentId}","1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
       assertEquals(responseJson,mvcResult.getResponse().getContentAsString());
    }
    @Test
    @DisplayName("analyze score user not found")
    void analyzeScoresNotFound() throws Exception {
        mockMvc.perform(get("/analyzeScores/{studentId}","11111111"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }

}
