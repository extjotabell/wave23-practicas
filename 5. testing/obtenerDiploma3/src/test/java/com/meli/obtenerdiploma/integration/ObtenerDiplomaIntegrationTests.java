package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("Analyze scores OK")
    void analyzeScoresOK() throws Exception {
        // Arrange
        StudentDTO student = new StudentDTO(
            1L,
            "Pepito Pérez",
            "Test message",
            10.0,
            new ArrayList<>(List.of(
                new SubjectDTO("Matemáticas", 8.0),
                new SubjectDTO("Física", 9.0),
                new SubjectDTO("Química", 10.0)
            ))
        );

        // Act
        mockMvc.perform(post("/student/registerStudent")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(student)))
            .andExpect(status().isOk()
        );

        mockMvc.perform(get("/analyzeScores/" + student.getId())
            .contentType("application/json"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.studentName").value(student.getStudentName())
        );
    }
}
