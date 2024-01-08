package com.meli.obtenerdiploma.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class StudentDiplomaTests {
    @Autowired
    private MockMvc mockMvc;

    private final ObjectWriter objectWriter = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

    @Test
    void registerStudentTestOk() throws Exception {
        StudentDTO responseDTO = TestGenerator.getStudentWith3Subjects("Marco");
        String payloadJson = this.objectWriter.writeValueAsString(responseDTO);

        this.mockMvc.perform(post("/student/registerStudent")
                        .contentType("application/json")
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void registerStudentTestError() throws Exception {
        StudentDTO responseDTO = TestGenerator.getStudentWith3Subjects( null);
        String payloadJson = this.objectWriter.writeValueAsString(responseDTO);

        this.mockMvc.perform(post("/student/registerStudent")
                        .contentType("application/json")
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void getStudentTestOk() throws Exception {
        StudentDTO studentDTO = TestGenerator.getStudentWith3Subjects("Marco");
        studentDTO.setId(2L);
        String payloadJson = this.objectWriter.writeValueAsString(studentDTO);

        MvcResult result = this.mockMvc.perform(get("/student/getStudent/{id}", 2L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(payloadJson))
                .andReturn();

        assertEquals(payloadJson, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    void getStudentTestError() throws Exception {
        String name = "StudentNotFoundException";
        String description = "El alumno con Id 100 no se encuetra registrado.";

        this.mockMvc.perform(get("/student/getStudent/{id}", 100L))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.description").value(description))
                .andReturn();
    }

    @Test
    void updateStudentTestOk() throws Exception {
        StudentDTO studentDTO = TestGenerator.getStudentWith3Subjects("Marco");
        studentDTO.setStudentName("Updated Name");
        String payloadJson = this.objectWriter.writeValueAsString(studentDTO);

        this.mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void updateStudentTestError() throws Exception {
        String exceptionName = "MethodArgumentNotValidException";
        String description = "El nombre del estudiante no puede estar vacío.";
        StudentDTO studentDTO = TestGenerator.getStudentWith3Subjects(null);
        studentDTO.setStudentName(null);
        String payloadJson = this.objectWriter.writeValueAsString(studentDTO);

        this.mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.name").value(exceptionName))
                .andExpect(jsonPath("$.description").value(description));
    }

    @Test
    void removeStudentTestOk() throws Exception {
        StudentDTO studentDTO = TestGenerator.getStudentWith3Subjects("Marco");

        this.mockMvc.perform(get("/student/removeStudent/{id}", studentDTO.getId()))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
