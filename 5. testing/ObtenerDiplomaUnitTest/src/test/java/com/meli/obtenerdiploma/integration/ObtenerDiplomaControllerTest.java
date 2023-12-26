package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTest {
    @Autowired
    MockMvc mockMvc;
    ObjectWriter writer;
    @Test
    public void analyzeScoresTest() throws Exception {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Juan");
        studentDTO.setSubjects(List.of(new SubjectDTO("Matemática",9.0)));
        studentDTO.setAverageScore(9.0);
        studentDTO.setMessage("El alumno Juan ha obtenido un promedio de 9. Puedes mejorar.");
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String payloadJson = writer.writeValueAsString(studentDTO);
        MvcResult mvcResult = this.mockMvc.perform(get("/analyzeScores/{studentId}", 2))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("El alumno Juan ha obtenido un promedio de 9. Puedes mejorar."))
                .andReturn();
        assertEquals(mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8), payloadJson);
    }

    @Test
    public void analyzeScoresExceptionTest() throws Exception {
        this.mockMvc.perform(get("/analyzeScores/{studentId}", 99))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }
}
