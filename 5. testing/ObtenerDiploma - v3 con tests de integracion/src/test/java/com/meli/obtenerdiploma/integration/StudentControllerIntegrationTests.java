package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void registerStudentTest() throws Exception {
        StudentDTO student = new StudentDTO(1L,"Marcos", null, null,
                                            List.of(new SubjectDTO("Matemática", 8.0)));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String payloadJson = writer.writeValueAsString(student);

        // Las 2 formas son válidas
        /*MvcResult result = this.mockMvc.perform(post("/student/registerStudent")
                                .contentType("application/json")
                                .content(payloadJson))
                                .andDo(print())
                                .andExpect(status().isOk())
                                .andReturn();

        assertEquals("", result.getResponse().getContentAsString());*/
        this.mockMvc.perform(post("/student/registerStudent")
                        .contentType("application/json")
                        .content(payloadJson))
                        .andDo(print())
                        .andExpect(status().isOk());
    }

    @Test
    void registerStudentExceptionTest() throws Exception {
        List<SubjectDTO> listaVacia = new ArrayList<>();
        StudentDTO student = new StudentDTO(1L,"Marcos", null, null, listaVacia);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String payloadJson = writer.writeValueAsString(student);

        this.mockMvc.perform(post("/student/registerStudent")
                        .contentType("application/json")
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    void getStudentTest() throws Exception {
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matemática", 8.0));
        StudentDTO student = new StudentDTO(1L,"Marcos", "El alumno Marcos ha obtenido un promedio de 8.00. Puedes mejorar.", 8.0, subjects);

        this.mockMvc.perform(get("/student/getStudent/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.studentName").value("Marcos"));
    }

    @Test
    void getStudentExceptionTest() throws Exception {
        this.mockMvc.perform(get("/student/getStudent/{id}", 1000))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    void modifyStudentTest() throws Exception {
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matemática", 8.0));
        StudentDTO student = new StudentDTO(1L,"Marcos", "El alumno Marcos ha obtenido un promedio de 8.00. Puedes mejorar.", 8.0, subjects);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String payloadJson = writer.writeValueAsString(student);

        this.mockMvc.perform(post("/student/modifyStudent")
                        .contentType("application/json")
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void modifyStudentExceptionTest() throws Exception {
        List<SubjectDTO> subjects = new ArrayList<>();
        StudentDTO student = new StudentDTO(1000L,"Marcos", null, null, subjects);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String payloadJson = writer.writeValueAsString(student);

        this.mockMvc.perform(post("/student/modifyStudent")
                        .contentType("application/json")
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    void removeStudentTest() throws Exception {
        this.mockMvc.perform(get("/student/removeStudent/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void listStudentsTest() throws Exception {
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matemática", 8.0));
        StudentDTO student = new StudentDTO(1L,"Marcos", "El alumno Marcos ha obtenido un promedio de 8.00. Puedes mejorar.", 8.0, subjects);

        Set<StudentDTO> students = new HashSet<>();
        students.add(student);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String payloadJson = writer.writeValueAsString(students);

        this.mockMvc.perform(get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(payloadJson));
    }
}
