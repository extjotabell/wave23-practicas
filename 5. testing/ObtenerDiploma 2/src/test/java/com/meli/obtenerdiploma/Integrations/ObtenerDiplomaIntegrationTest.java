package com.meli.obtenerdiploma.Integrations;

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

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// Annotate the class for Spring Boot testing
@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaIntegrationTest {

    // Autowire necessary components
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Test case for analyzing scores successfully")
    void analyzeScoresTestOk() throws Exception {
        // Create a response DTO with student information
        StudentDTO responseDTO = new StudentDTO(
                1L,
                "Juan",
                "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.",
                7.333333333333333,
                List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)
                ));

        // Create an ObjectWriter with specified serialization settings
        ObjectWriter objecTWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        // Convert response DTO to JSON
        String responseJson = objecTWriter.writeValueAsString(responseDTO);

        // Perform a GET request to analyze scores and expect an OK response
        MvcResult mvcResult = this.mockMvc.perform(get("/analyzeScores/{studentId}", 1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        // Verify that the correct response JSON is returned
        assertEquals(responseJson, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("Test case for handling an exception when analyzing scores for a non-existent student")
    public void analyzeScoresExceptionTest() throws Exception {
        // Perform a GET request to analyze scores for a non-existent student and expect a not found response
        this.mockMvc.perform(get("/analyzeScores/{studentId}", 100))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.description").value("El alumno con Id 100 no se encuetra registrado."))
                .andReturn();
    }
}
