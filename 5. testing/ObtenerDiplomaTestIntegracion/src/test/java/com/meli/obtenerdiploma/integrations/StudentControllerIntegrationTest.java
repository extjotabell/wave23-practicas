package com.meli.obtenerdiploma.integrations;

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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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

    @DisplayName("Register student (Success)")
    @Test
    public void registerStudentIntegrationTest() throws Exception{
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matematica",9.0));
        subjects.add(new SubjectDTO("Fisica",7.0));
        subjects.add(new SubjectDTO("Quimica",6.0));
        StudentDTO test_student = new StudentDTO(10L,"Juan",null,null,subjects);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();

        String payloadJson = writer.writeValueAsString(test_student);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @DisplayName("Register student (Exception)")
    @Test
    public void registerStudentNOKIntegrationTest() throws Exception{
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matematica",9.0));
        subjects.add(new SubjectDTO("Fisica",7.0));
        subjects.add(new SubjectDTO("Quimica",6.0));
        StudentDTO test_student = new StudentDTO(null,null,null,null,subjects);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();

        String payloadJson = writer.writeValueAsString(test_student);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andReturn();
    }

    @DisplayName("Test get student by id (Success)")
    @Test
    public void getStudentByIdIntegrationTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Juan"));
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
    public void modifyStudentIntegrationTest() throws Exception{
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matematica",9.0));
        subjects.add(new SubjectDTO("Fisica",7.0));
        subjects.add(new SubjectDTO("Quimica",6.0));
        StudentDTO test_student = new StudentDTO(1L,"Juan",null,null,subjects);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();

        String payloadJson = writer.writeValueAsString(test_student);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @DisplayName("Test modify student (Exception)")
    @Test
    public void modifyStudentNOKIntegrationTest() throws Exception{
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matematica",9.0));
        subjects.add(new SubjectDTO("Fisica",7.0));
        subjects.add(new SubjectDTO("Quimica",6.0));
        StudentDTO test_student = new StudentDTO(1L,null,null,null,subjects);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();

        String payloadJson = writer.writeValueAsString(test_student);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andReturn();
    }

    @DisplayName("Test remove student (Success)")
    @Test
    public void removeStudentIntegrationTest() throws Exception{

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}",99))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }


    @DisplayName("Test list student (Success)")
    @Test
    public void listStudentsIntegrationTest() throws Exception{

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(mvcResult.getResponse().getContentAsString().length(),525);
    }

}

