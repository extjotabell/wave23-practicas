package com.meli.obtenerdiploma.integrationtest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ObtenerDiplomaIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    private static final StudentDAO studentDAO = new StudentDAO();
    private static ObjectWriter objectWriter;
    private SubjectDTO kahoot;
    private SubjectDTO musica;
    private SubjectDTO poo;
    private StudentDTO student;

    @BeforeAll
    public static void setUp() {
        objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
    }

    @BeforeEach
    void beforeEach() {
        kahoot = new SubjectDTO("Kahoot", 1.0);
        musica = new SubjectDTO("Musica", 9.0);
        poo = new SubjectDTO("POO", 2.0);

        student = new StudentDTO(
                1L,
                "Fernando",
                "El alumno Fernando ha obtenido un promedio de 4,00. Puedes mejorar.",
                4.0,
                List.of(kahoot, musica, poo));

        if ( ! studentDAO.exists(student))
            studentDAO.save(student);
    }

    @Test
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


        String response = objectWriter.writeValueAsString(stu);


        MvcResult mvcResult =
                this.mockMvc.perform(get("/analyzeScores/{studentId}", "1"))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andReturn();

        Assertions.assertEquals(response, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    void helloTest() throws Exception {
        // Arrange
        String userJson = objectWriter.writeValueAsString(student);
        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedJson = content().json(userJson);
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
                "/analyzeScores/{studentId}",
                1);
        // Act & Assert
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedContentType)
                .andExpect(expectedJson)
                .andExpect(expectedStatus);
    }

    @Test
    void testGivenAnInvalidStudentIdThrowExceptionMessage() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 22))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));
    }

}
