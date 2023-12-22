package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {
    @Autowired
    MockMvc mock;

    private StudentDTO studentDTO;
    private ObjectWriter writer;

    @BeforeEach
    void initialize() {
        studentDTO = new StudentDTO(
                1L,
                "Juan",
                "",
                0.0,
                new ArrayList<>() {{
                    add(new SubjectDTO("Matemática", 9.0));
                    add(new SubjectDTO("Física", 7.0));
                    add(new SubjectDTO("Química", 6.0));
                }}
        );

        writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    @DisplayName("Test register student successfully")
    void registerStudentOk() throws Exception {
        String payloadJson = writer.writeValueAsString(studentDTO);

        this.mock.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test register student with empty subjects list")
    void registerStudentWithEmptyList() throws Exception {
        ErrorDTO responseDTO = new ErrorDTO(
                "MethodArgumentNotValidException",
                "La lista de materias no puede estar vacía."
        );
        String responseJson = writer.writeValueAsString(responseDTO);

        studentDTO.setSubjects(new ArrayList<>());
        String payloadJson = writer.writeValueAsString(studentDTO);

        MvcResult result = this.mock.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andReturn();

        assertEquals(responseJson, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("Test register student with empty student name")
    void registerStudentWithEmptyName() throws Exception {
        ErrorDTO responseDTO = new ErrorDTO(
                "MethodArgumentNotValidException",
                "El nombre del estudiante no puede estar vacío."
        );
        String responseJson = writer.writeValueAsString(responseDTO);

        studentDTO.setStudentName("");
        String payloadJson = writer.writeValueAsString(studentDTO);

        MvcResult result = this.mock.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andReturn();

        assertEquals(responseJson, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("Test register student with wrong student name")
    void registerStudentWithWrongName() throws Exception {
        ErrorDTO errorResponse = new ErrorDTO(
                "MethodArgumentNotValidException",
                "El nombre del estudiante debe comenzar con mayúscula."
        );
        String responseJson = writer.writeValueAsString(errorResponse);

        studentDTO.setStudentName("juan");
        String payloadJson = writer.writeValueAsString(studentDTO);

        MvcResult result = this.mock.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andReturn();

        assertEquals(responseJson, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("Test get student successfully")
    void getStudentOk() throws Exception {
        this.mock.perform(get("/student/getStudent/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    @DisplayName("Test get student with wrong id")
    void getStudentWithWrongId() throws Exception {
        ErrorDTO errorResponse = new ErrorDTO(
                "StudentNotFoundException",
                "El alumno con Id 99 no se encuetra registrado."
        );
        String responseJson = writer.writeValueAsString(errorResponse);

        MvcResult result = this.mock.perform(get("/student/getStudent/{id}", 99L))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseJson, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("Test modify student successfully")
    void modifyStudentOk() throws Exception {
        String payloadJson = writer.writeValueAsString(studentDTO);

        this.mock.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test remove student successfully")
    void removeStudentOk() throws Exception {
        this.mock.perform(get("/student/removeStudent/{id}", 2L))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test list students successfully")
    void listStudentsOk() throws Exception {
        Set<StudentDTO> responseList = this.createDummyStudentSet();
        String responseJson = writer.writeValueAsString(responseList);

        MvcResult result = this.mock.perform(get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(responseJson, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    private Set<StudentDTO> createDummyStudentSet() {
        Set<StudentDTO> loadedData = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("./src/test/resources/users.json");
            loadedData = objectMapper.readValue(file, new TypeReference<Set<StudentDTO>>(){});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }

        return loadedData;
    }
}