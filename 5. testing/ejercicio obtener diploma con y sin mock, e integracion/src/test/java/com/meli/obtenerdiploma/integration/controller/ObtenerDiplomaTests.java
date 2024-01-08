package com.meli.obtenerdiploma.integration.controller;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ObtenerDiplomaController.class)
class ObtenerDiplomaTests {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private IObtenerDiplomaService service;

    @BeforeEach
    @AfterEach
    public void setUp() {
        TestGenerator.emptyUsersFile();
    }

    @Test
    void validarUsuario() throws Exception {
        StudentDTO expectedStudent = TestGenerator.getStudentWith3Subjects("Juan");
        Long studentId = 1L;
        when(service.analyzeScores(studentId)).thenReturn(expectedStudent);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", studentId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.studentName").exists())
                .andExpect(jsonPath("$.subjects").exists())
                .andReturn();

        Assertions.assertEquals("application/json", mvcResult.getResponse().getContentType());
    }

    @Test
    void validarDatosEsperados() throws Exception {
        StudentDTO expectedStudent = TestGenerator.getStudentWith3Subjects("Juan");
        Long studentId = 1L;
        when(service.analyzeScores(studentId)).thenReturn(expectedStudent);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", studentId))
                .andDo(print())
                .andExpect(jsonPath("$.studentName").value("Juan"))
                .andReturn();

        Assertions.assertEquals("application/json", mvcResult.getResponse().getContentType());
    }

    @Test
    void validarListaSubject() throws Exception {
        StudentDTO expectedStudent = TestGenerator.getStudentWith3Subjects("Juan");
        Long studentId = 1L;
        when(service.analyzeScores(studentId)).thenReturn(expectedStudent);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", studentId))
                .andDo(print())
                .andExpect(jsonPath("$.subjects", hasSize(3)))
                .andReturn();

        Assertions.assertEquals("application/json", mvcResult.getResponse().getContentType());
    }

    @Test
    void validarIdIncorrecto() throws Exception {
        StudentDTO expectedStudent = TestGenerator.getStudentWith3Subjects("Juan");
        expectedStudent.setId(1L);
        Long studentId = 2L;
        when(service.analyzeScores(studentId)).thenReturn(expectedStudent);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", studentId))
                .andDo(print())
                .andExpect(jsonPath("$.id").value(1))
                .andReturn();

        Assertions.assertEquals("application/json", mvcResult.getResponse().getContentType());
    }
}
