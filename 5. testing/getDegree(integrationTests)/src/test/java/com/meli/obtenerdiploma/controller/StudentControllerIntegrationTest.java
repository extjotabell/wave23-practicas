package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.MethodArgumentNotValidException;
import static  org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testRegisterStudentok() throws Exception{
        // Crear un nuevo estudiante
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(3L);
        studentDTO.setStudentName("Andres");
        studentDTO.setSubjects(Arrays.asList(new SubjectDTO("Matematica", 9.00),
                new SubjectDTO("Lengua", 9.00),
                new SubjectDTO("Fisica", 9.00)));

        String studentJson = objectMapper.writeValueAsString(studentDTO);

        mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentJson))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void testRegisterStudentFailed() throws Exception {
        // Crear un nuevo estudiante
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Andres");
        studentDTO.setId(1L);

        String studentJson = objectMapper.writeValueAsString(studentDTO);

        mockMvc.perform(post("/student/registerStudent")
               .contentType(MediaType.APPLICATION_JSON)
               .content(studentJson))
               .andDo(print())
               .andExpect(status().isBadRequest());
    }

    @Test
    void testRegisterStudentException() throws Exception {
        // Crear un nuevo estudiante
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Andres");
        studentDTO.setId(1L);

        String studentJson = objectMapper.writeValueAsString(studentDTO);

        mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException));
    }
}
