package com.meli.obtenerdiploma.integrationTest;

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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Happy Path")
    void testAnalizeScore() throws Exception {
        //Arrange
        SubjectDTO subject1 = new SubjectDTO("Matemática", 9.0);
        SubjectDTO subject3 = new SubjectDTO("Física", 7.0);
        SubjectDTO subject2 = new SubjectDTO("Química", 6.0);

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject3);
        subjects.add(subject2);

        StudentDTO stu = new StudentDTO();
        stu.setId(1L);
        stu.setStudentName("Juan");
        stu.setSubjects(subjects);

        stu.setAverageScore(((9.0 + 7.0 + 6.0)/3));
        stu.setMessage("El alumno " + stu.getStudentName() + " ha obtenido un promedio de " + "7.33" + ". Puedes mejorar.");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String response = writer.writeValueAsString(stu);

        //Act

        MvcResult mvcResult =
                this.mockMvc.perform(get("/analyzeScores/{studentId}", "1"))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andReturn();


        //Assert

        Assertions.assertEquals(response, mvcResult.getResponse().getContentAsString(Charset.forName("UTF-8")));
    }

    @Test
    @DisplayName("Sad Path")
    void testAnalizeScoreNotOk() throws Exception {

        String message = "El alumno con Id 4 no se encuetra registrado.";

        MvcResult mvcResult =
                this.mockMvc.perform(get("/analyzeScores/{studentId}", "4"))
                        .andDo(print())
                        .andExpect(status().isNotFound())
                        .andExpect(jsonPath("$.description").value(message))
                        .andReturn();

    }
}
