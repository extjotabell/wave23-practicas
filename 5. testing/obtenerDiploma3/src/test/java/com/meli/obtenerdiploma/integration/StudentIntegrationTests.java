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
public class StudentIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("Register student OK")
    void registerStudentOK() throws Exception {
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
    }

    @Test
    @DisplayName("Register student with invalid arguments")
    void registerStudentWithInvalidArguments() throws Exception {
        // Arrange
        StudentDTO student = new StudentDTO(
            1L,
            "",
            "Test message",
            10.0,
            new ArrayList<>()
        );

        // Act
        mockMvc.perform(post("/student/registerStudent")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(student)))
            .andExpect(status().isBadRequest()
        );
    }

    @Test
    @DisplayName("Register student with no body")
    void registerStudentWithNoBody() throws Exception {
        // Act
        mockMvc.perform(post("/student/registerStudent")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(null)))
            .andExpect(status().isBadRequest()
        );
    }

    @Test
    @DisplayName("Get student OK")
    void getStudentOK() throws Exception {
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

        mockMvc.perform(get("/student/getStudent/" + student.getId()))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.studentName").value(student.getStudentName()))
            .andExpect(jsonPath("$.id").value(student.getId())
        );
    }

    @Test
    @DisplayName("Get student non-existent")
    void getStudentNonExistent() throws Exception {
        mockMvc.perform(get("/student/getStudent/" + 34L))
            .andExpect(status().isNotFound()
        );
    }

    @Test
    @DisplayName("Modify student OK")
    void modifyStudentOK() throws Exception {
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

        mockMvc.perform(get("/student/getStudent/" + student.getId()))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.studentName").value(student.getStudentName()))
            .andExpect(jsonPath("$.id").value(student.getId())
        );

        student.setStudentName("Pepito Pérez modificado");

        mockMvc.perform(post("/student/modifyStudent")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(student)))
            .andExpect(status().isOk()
        );

        mockMvc.perform(get("/student/getStudent/" + student.getId()))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.studentName").value(student.getStudentName()))
            .andExpect(jsonPath("$.id").value(student.getId())
        );
    }

    @Test
    @DisplayName("Modify student with invalid arguments")
    void modifyStudentNonExistent() throws Exception {
        // Arrange
        StudentDTO student = new StudentDTO(
            34L,
            "",
            "Test message",
            10.0,
            new ArrayList<>(List.of(
                new SubjectDTO("Matemáticas", 8.0),
                new SubjectDTO("", 9.0),
                new SubjectDTO("Química", 11.4)
            ))
        );

        // Act
        mockMvc.perform(post("/student/modifyStudent")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(student)))
            .andExpect(status().isBadRequest()
        );
    }

    @Test
    @DisplayName("Modify student with no body")
    void modifyStudentWithNoBody() throws Exception {
        // Act
        mockMvc.perform(post("/student/modifyStudent")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(null)))
            .andExpect(status().isBadRequest()
        );
    }

    @Test
    @DisplayName("Delete student OK")
    void deleteStudentOK() throws Exception {
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

        mockMvc.perform(get("/student/getStudent/" + student.getId()))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.studentName").value(student.getStudentName()))
            .andExpect(jsonPath("$.id").value(student.getId())
        );

        mockMvc.perform(get("/student/removeStudent/" + student.getId()))
            .andExpect(status().isOk()
        );

        mockMvc.perform(get("/student/getStudent/" + student.getId()))
            .andExpect(status().isNotFound()
        );
    }

    @Test
    @DisplayName("List all students OK")
    void listAllStudentsOK() throws Exception {
        // Arrange
        for (long i = 1L; i <= 10L; i++) {
            StudentDTO student = new StudentDTO(
                i,
                "Pepito Pérez" + i,
                "Test message",
                10.0,
                new ArrayList<>(List.of(
                    new SubjectDTO("Matemáticas", 8.0),
                    new SubjectDTO("Física", 9.0),
                    new SubjectDTO("Química", 10.0)
                ))
            );

            mockMvc.perform(post("/student/registerStudent")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isOk()
            );
        }

        // Act
        mockMvc.perform(get("/student/listStudents"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()").value(10)
        );
    }
}
