package com.meli.obtenerdiploma.controller;

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
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    @AfterEach
    private void setUp() {
        TestUtilsGenerator.emptyUsersFile();
    }


    @Test
    void registerStudent_shouldReturnOk_whenStudentIsValid() throws Exception {
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Valid Student");

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isOk());
    }

    @Test
    void registerStudent_shouldReturnBadRequest_whenStudentIsInvalid() throws Exception {
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("");

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void registerStudent_shouldReturnBadRequest_whenStudentIsNull() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(null)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getStudent_shouldReturnStudent_whenStudentExists() throws Exception {
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
    void getStudent_shouldReturnNotFound_whenStudentDoesNotExist() throws Exception {
        Long id = 999L;

        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", id))
                .andExpect(status().isNotFound());
    }

    @Test
    void modifyStudent_shouldReturnOk_whenStudentIsValid() throws Exception {
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Valid Student");


        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isOk());
    }

    @Test
    void modifyStudent_shouldReturnBadRequest_whenStudentIsInvalid() throws Exception {
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("");

        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void modifyStudent_shouldReturnBadRequest_whenStudentIsNull() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(null)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void removeStudent_shouldReturnOk_whenStudentExists() throws Exception {
        Long id = 1L;

        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", id))
                .andExpect(status().isOk());
    }

    @Test
    void listStudents_shouldReturnListOfStudentDTOs() throws Exception {
        Set<StudentDTO> students = TestUtilsGenerator.getStudentSet();

        for (StudentDTO student : students) {
            mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(student)))
                    .andExpect(status().isOk());
        }

        mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(students.size())));
    }

    @Test
    void listStudents_shouldReturnEmptyListWhenNoStudentsExist() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }
}
