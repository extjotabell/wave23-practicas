package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {
    @Autowired
    MockMvc mockMvc;
    ObjectWriter writer;

    @Test
    public void registerStudentTest() throws Exception {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Juan");
        studentDTO.setSubjects(List.of(new SubjectDTO("Matemática",9.0)));

        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String payloadJson = writer.writeValueAsString(studentDTO);
        this.mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void registerStudentExceptionTest() throws Exception {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("juan");
        studentDTO.setSubjects(List.of(new SubjectDTO("Matemática",9.0)));

        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String payloadJson = writer.writeValueAsString(studentDTO);
        this.mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andReturn();
    }

    @Test
    public void getStudentTest() throws Exception {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Juan");
        studentDTO.setSubjects(List.of(new SubjectDTO("Matemática",9.0)));
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String payloadJson = writer.writeValueAsString(studentDTO);
        MvcResult mvcResult = this.mockMvc.perform(get("/student/getStudent/{id}", 2))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        assertEquals(mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8), payloadJson);
       }

    @Test
    public void getStudentExceptionTest() throws Exception {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        this.mockMvc.perform(get("/student/getStudent/{id}", 99))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }


    @Test
    public void modifyStudentTest() throws Exception {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Juan");
        studentDTO.setSubjects(List.of(new SubjectDTO("Matemática",9.0)));

        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String payloadJson = writer.writeValueAsString(studentDTO);
        this.mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void modifyStudentExceptionTest() throws Exception {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(22L);
        studentDTO.setStudentName("juan");
        studentDTO.setSubjects(List.of(new SubjectDTO("Matemática",9.0)));

        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String payloadJson = writer.writeValueAsString(studentDTO);
        this.mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andReturn();
    }

    @Test
    public void removeTest() throws Exception {
        this.mockMvc.perform(get("/student/removeStudent/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

    }

    @Test
    public void listStudentsTest() throws Exception {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Juan");
        studentDTO.setSubjects(List.of(new SubjectDTO("Matemática",9.0)));
        StudentDTO studentDTO2 = new StudentDTO();
        studentDTO2.setId(2L);
        studentDTO2.setStudentName("Pedro");
        studentDTO2.setSubjects(List.of(new SubjectDTO("Matemática",10.0)));

        List<StudentDTO> studentDTOList = List.of(studentDTO, studentDTO2);
         writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String payloadJson = writer.writeValueAsString(studentDTOList);

        MvcResult mvcResult = this.mockMvc.perform(get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        assertEquals(mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8), payloadJson);
    }


}
