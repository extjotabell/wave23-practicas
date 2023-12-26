package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class StudentControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void registerStudentIntegrationsTest() throws Exception {
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matemática", 8.0));
        StudentDTO student = new StudentDTO(22L, "Tomi", "Gol", 8.0, subjects);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String payloadJson = writer.writeValueAsString(student);

        this.mockMvc.perform(post("/student/registerStudent")
                        .contentType("application/json")
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void registerStudentExceptionIntegrationsTest() throws Exception {
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matemática", 8.0));
        StudentDTO student = new StudentDTO(22L, "tomi", "Gol", 8.0, subjects);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String payloadJson = writer.writeValueAsString(student);

        this.mockMvc.perform(post("/student/registerStudent")
                        .contentType("application/json")
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void getStudentIntegrationTest() throws Exception {
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matemática", 8.0));
        StudentDTO student = new StudentDTO(1L, "Marcos", null, null, subjects);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String payloadJson = writer.writeValueAsString(student);

        MvcResult result = this.mockMvc.perform(get("/student/getStudent/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(result.getResponse().getContentAsString(StandardCharsets.UTF_8), payloadJson);
    }

    @Test
    public void getStudentExceptionIntegrationTest() throws Exception {
        this.mockMvc.perform(get("/student/getStudent/{id}", 22L))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"));

    }

    @Test
    public void modifyStudentIntegrationTest() throws Exception {
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matemática", 8.0));
        StudentDTO student = new StudentDTO(1L, "Marcos", null, null, subjects);

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
    public void modifyStudentExceptionIntegrationTest() throws Exception {
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matemática", 8.0));
        StudentDTO student = new StudentDTO(1L, "marcos", null, null, subjects);

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


}
