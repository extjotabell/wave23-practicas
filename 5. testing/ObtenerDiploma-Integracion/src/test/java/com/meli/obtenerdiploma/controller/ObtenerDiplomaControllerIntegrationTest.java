package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ObtenerDiplomaControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void analyzeScoresWhenStudentIdExist() throws Exception {
        Long studentId = 1L;
        StudentDTO expectedStudent = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        expectedStudent.setId(studentId);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(expectedStudent)))
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", studentId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.studentName").value(expectedStudent.getStudentName()))
                .andExpect(jsonPath("$.subjects", hasSize(3)));
    }

    @Test
    void analyzeScoresWhenStudentIdNotExist() throws Exception {
        Long studentId = 123L;

        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", studentId))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.description").value("El alumno con Id "+ studentId + " no se encuetra registrado."));

    }

}
