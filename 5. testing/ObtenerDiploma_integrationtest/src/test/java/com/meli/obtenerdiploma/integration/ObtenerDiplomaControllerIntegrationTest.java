package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter objectWriter = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .writer();

    @Test
    @DisplayName("Test Analyze Scores - OK")
    void testAnalyzeScores_OK() throws Exception{
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Matemática", 8.0),
                new SubjectDTO("Física", 8.0)
        );

        StudentDTO student = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de 8.00. Puedes mejorar.", 8.0, subjects);

        MockHttpServletRequestBuilder request = get("/analyzeScores/{studentId}", 1);

        MvcResult result = mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(objectWriter.writeValueAsString(student), result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("Test Analyze Scores - StudentNotFound Exception")
    void testAnalyzeScores_ThrowsStudentNotFoundException() throws Exception{
        MockHttpServletRequestBuilder request = get("/analyzeScores/{studentId}", 999);

       mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El alumno con Id 999 no se encuetra registrado."));
    }

}
