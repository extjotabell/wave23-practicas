package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.BDDAssumptions.given;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ObtenerDiplomaController.class)
class ObtenerDiplomaControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private IObtenerDiplomaService service;

    @BeforeEach
    @AfterEach
    private void setUp() {
        TestUtilsGenerator.emptyUsersFile();
    }

    @Test
    void analyzeScoresReturnsStudentDTOWhenStudentIdExists() throws Exception {
        Long studentId = 1L;
        StudentDTO expectedStudent = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        when(service.analyzeScores(studentId)).thenReturn(expectedStudent);

        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/" + studentId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.studentName").value("Marco"))
                .andExpect(jsonPath("$.subjects", hasSize(3)));
    }

}
