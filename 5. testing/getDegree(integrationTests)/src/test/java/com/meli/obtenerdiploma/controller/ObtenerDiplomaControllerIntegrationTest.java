package com.meli.obtenerdiploma.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testAnalyzeScores() throws Exception {
        this.mockMvc.perform(get("/analyzeScores/1")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.studentName").exists());
    }

    @Test
    void testAnalyzeScoresWithNonExistentStudentId() throws Exception {
        Long nonExistentStudentId = 999L;
        this.mockMvc.perform(get("/analyzeScores/" + nonExistentStudentId)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isNotFound());
    }

    @Test
    void testAnalyzeScoresWithInvalidStudentId() throws Exception {
        String invalidStudentId = "invalid_id";
        this.mockMvc.perform(get("/analyzeScores/" + invalidStudentId)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isBadRequest());
    }
}
