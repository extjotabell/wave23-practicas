package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class Integration1Test {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    @BeforeAll
    public static void writer(){
        writer =  new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    void analyzeScoresTest() throws Exception{


        StudentDTO stu = createStudentWithAverage();

        String response = writer.writeValueAsString(stu);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}","1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(response, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));

    }

    public StudentDTO createStudentWithAverage(){
        return new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.", ((9.0 + 7.0 + 6.0)/3),
                List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)
                ));
    }

    public StudentDTO createStudent(){
        return new StudentDTO(1L, "Juan", null, null,
                List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)
                ));
    }

    @Test
    void registerStudentTest() throws Exception{

        StudentDTO payloadBody = createStudent();

        String payloadJson = writer.writeValueAsString(payloadBody);

        this.mockMvc.perform(post("/student/registerStudent")
                    .contentType("application/json")
                    .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getStudentTest() throws Exception{

        StudentDTO studentDTO = createStudent();

        String response = writer.writeValueAsString(studentDTO);

         MvcResult mvcResult = this.mockMvc.perform(get("/student/getStudent/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(response, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    void modifyStudentTest() throws Exception{
        StudentDTO payloadBody = createStudent();

        String response = writer.writeValueAsString(payloadBody);

        this.mockMvc.perform(post("/student/modifyStudent")
                .contentType("application/json")
                .content(response))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void removeStudentTest() throws Exception{

        this.mockMvc.perform(get("/student/removeStudent/{id}", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }



}
