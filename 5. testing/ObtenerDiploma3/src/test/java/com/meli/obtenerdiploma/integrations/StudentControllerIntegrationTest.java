package com.meli.obtenerdiploma.integrations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.spel.ast.TypeReference;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.tags.EscapeBodyTag;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @DisplayName("Test register student (Success)")
    @Test
    public void registerStudent() throws Exception {
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matematica",9.0));
        subjects.add(new SubjectDTO("Fisica",7.0));
        subjects.add(new SubjectDTO("Quimica",6.0));
        StudentDTO test_student = new StudentDTO(10L,"Juan",null,null,subjects);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();

        String payload = writer.writeValueAsString(test_student);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent").
                contentType(MediaType.APPLICATION_JSON).
                content(payload)).
                andDo(print()).andExpect(status().isOk())
                .andReturn();
    }

    @DisplayName("Test register student (Exception)")
    @Test
    public void registerStudentException() throws Exception {
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matematica",9.0));
        subjects.add(new SubjectDTO("Fisica",7.0));
        subjects.add(new SubjectDTO("Quimica",6.0));
        StudentDTO test_student = new StudentDTO(null,null,null,null,subjects);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();

        String payload = writer.writeValueAsString(test_student);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent").
                        contentType(MediaType.APPLICATION_JSON).
                        content(payload)).
                andDo(print()).andExpect(status().is4xxClientError())
                .andReturn();
    }

    @DisplayName("Test get student by id (Success)")
    @Test
    public void getStudentByIdIntegrationTest() throws Exception{
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matematica",9.0));
        subjects.add(new SubjectDTO("Fisica",7.0));
        subjects.add(new SubjectDTO("Quimica",6.0));
        StudentDTO test_student = new StudentDTO(1L,"Juan",null,null,subjects);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();

        String response = writer.writeValueAsString(test_student);

        MvcResult mvcResult =  this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(response,mvcResult.getResponse().getContentAsString());
    }

    @DisplayName("Test get student by id (Exception)")
    @Test
    public void getStudentByIdIntegrationTestException() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",10))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("StudentNotFoundException"));
    }

    @DisplayName("Test modify student (Success)")
    @Test
    public void modifyStudent() throws Exception {
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matematica",9.0));
        subjects.add(new SubjectDTO("Fisica",7.0));
        subjects.add(new SubjectDTO("Quimica",6.0));
        StudentDTO test_student = new StudentDTO(1L,"Juan",null,null,subjects);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();

        String payload = writer.writeValueAsString(test_student);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent").
                        contentType(MediaType.APPLICATION_JSON).
                        content(payload)).
                andDo(print()).andExpect(status().isOk())
                .andReturn();
    }

    @DisplayName("Test modify student (Exception)")
    @Test
    public void modifyStudentException() throws Exception {
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matematica",9.0));
        subjects.add(new SubjectDTO("Fisica",7.0));
        subjects.add(new SubjectDTO("Quimica",6.0));
        StudentDTO test_student = new StudentDTO(null,null,null,null,subjects);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();

        String payload = writer.writeValueAsString(test_student);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent").
                        contentType(MediaType.APPLICATION_JSON).
                        content(payload)).
                andDo(print()).andExpect(status().is4xxClientError())
                .andReturn();
    }

    @DisplayName("Test delete student by id (Success)")
    @Test
    public void removeStudent() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}",23))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @DisplayName("Test list student (Success)")
    @Test
    public void listStudents() throws Exception {
        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();

        MvcResult mvcResult =  this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(mvcResult.getResponse().getContentAsString().length(),522);
    }

}
