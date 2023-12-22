package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ObtenerDiplomaIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void analyzeScoresReturnsStudentDTOWhenStudentIdExists() throws Exception {
        Long studentId = 1L;
        StudentDTO expectedStudent = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        expectedStudent.setId(studentId);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(expectedStudent)))
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/" + studentId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.studentName").value(expectedStudent.getStudentName()))
                .andExpect(jsonPath("$.subjects", hasSize(3)));
    }

    @BeforeEach
    private void setUp() {
        TestUtilsGenerator.emptyUsersFile();
    }


    @Test
    void registerStudentIsValid() throws Exception {
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Valid Student");

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isOk());
    }

    @Test
    void registerStudentIsInvalid() throws Exception {
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("");

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void registerStudentIsNull() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(null)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getStudentIsValid() throws Exception {
        Long id = 1L;
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(id.intValue())))
                .andExpect(jsonPath("$.studentName", is("Juan")));
    }

    @Test
    void getStudentDoesNotExist() throws Exception {
        Long id = 999L;

        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", id))
                .andExpect(status().isNotFound());
    }

    @Test
    void modifyStudentIsValid() throws Exception {
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Valid Student");


        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isOk());
    }

    @Test
    void modifyStudentIsInvalid() throws Exception {
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("");

        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void modifyStudentIsNull() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(null)))
                .andExpect(status().isBadRequest());
    }
}
