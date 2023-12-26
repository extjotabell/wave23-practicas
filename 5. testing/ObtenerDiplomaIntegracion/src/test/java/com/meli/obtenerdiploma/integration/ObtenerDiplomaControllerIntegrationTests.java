package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ObtenerDiplomaControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;


    @Test
    public void analyzeScoresTest() throws Exception {
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matemática", 8.0));
        StudentDTO student = new StudentDTO(2L, "Tomi", "El alumno Tomi ha obtenido un promedio de 8.00. Puedes mejorar.", 8.0, subjects);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String payloadJson = writer.writeValueAsString(student);

        MvcResult result = this.mockMvc.perform(get("/analyzeScores/{studentId}", 2L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("El alumno Tomi" +
                        " ha obtenido un promedio de 8.00. Puedes mejorar."))
                .andReturn();

        assertEquals(result.getResponse().getContentAsString(StandardCharsets.UTF_8), payloadJson);
    }

    @Test
    public void analyzeScoresExceptionTest() throws Exception {
        this.mockMvc.perform(get("/analyzeScores/{studentId}", 99))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.description").value("El alumno con Id 99 no se encuetra registrado."))
                .andReturn();

    }

}
