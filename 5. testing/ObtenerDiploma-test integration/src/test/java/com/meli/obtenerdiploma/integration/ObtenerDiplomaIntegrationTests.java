package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ObtenerDiplomaIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private StudentDAO studentDAO;

    @BeforeEach
    public void beforEach() {
        //Arrange
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        studentDTO.setId(1L);

        if( ! studentDAO.exists( studentDTO ) )
            studentDAO.save( studentDTO );

    }

    @Test
    @DisplayName("GET ENDPOINT: Analyze scores with valid student.")
    void analyceScoreWithExistingIdShouldReturnStudent() throws Exception {
        //Act - Assert
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.studentName").value("Marco"))
                .andExpect(jsonPath("$.averageScore").value(6.0))
                .andExpect(jsonPath("$.subjects.length()").value(3))
                .andExpect(jsonPath("$.subjects[?(@.name == \""+"Matemática"+"\"  && @.score == "+8.0+")]").exists())
                .andExpect(jsonPath("$.subjects[?(@.name == \""+"Lengua"+"\"  && @.score == "+6.0+")]").exists())
                .andExpect(jsonPath("$.subjects[?(@.name == \""+"Física"   +"\"  && @.score == "+4.0+")]").exists());
    }

    @Test
    @DisplayName("GET ENDPOINT: Analyze scores with invalid student.")
    void analyceScoreWithInvalidIdStudentIdThrowExceptionMessage() throws Exception {
        //Act - Assert
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 502))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));
    }
}
