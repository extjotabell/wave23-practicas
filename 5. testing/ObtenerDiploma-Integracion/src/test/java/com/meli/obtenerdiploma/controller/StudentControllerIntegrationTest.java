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

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    @AfterEach
    private void setUp() {
        TestUtilsGenerator.emptyUsersFile();
    }

    @Test
    void registerStudentWhenStudentIsValid() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Juan");

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(studentDTO)))
                .andExpect(status().isOk());
    }

    @Test
    void registerStudentWhenStudentIsInvalid() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        studentDTO.setStudentName(null);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(studentDTO)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getStudentWhenStudentIdExist() throws Exception {
        Long studentId = 1L;
        StudentDTO expectedStudent = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        expectedStudent.setId(studentId);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(expectedStudent)))
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{studentId}", studentId))
                .andExpect(status().isOk());
    }

    @Test
    void getStudentWhenStudentIdNotExist() throws Exception {
        Long studentId = 123L;

        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{studentId}", studentId))
                .andExpect(status().isNotFound());
    }

    @Test
    void modifyStudentWhenStudentIsValid() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Juan");

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(studentDTO)))
                .andExpect(status().isOk());

        studentDTO.setStudentName("Juan Carlos");

        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(studentDTO)))
                .andExpect(status().isOk());
    }

    @Test
    void modifyStudentWhenStudentIsInvalid() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Juan");

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(studentDTO)))
                .andExpect(status().isOk());

        studentDTO.setStudentName(null);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(studentDTO)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void removeStudentWhenStudentIdExist() throws Exception {
        Long studentId = 1L;
        StudentDTO expectedStudent = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        expectedStudent.setId(studentId);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(expectedStudent)))
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{studentId}", studentId))
                .andExpect(status().isOk());
    }

    @Test
    void removeStudentWhenStudentIdNotExist() throws Exception {
        Long studentId = 765L;

        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{studentId}", studentId))
                .andExpect(status().isOk());
    }

    @Test
    void listStudents() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andExpect(status().isOk());
    }

    @Test
    void listStudentsReturnEmptyListWhenNoStudentsExist() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    void listStudentsReturnListWithOneStudentWhenOneStudentExist() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Juan");

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(studentDTO)))
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }
}
