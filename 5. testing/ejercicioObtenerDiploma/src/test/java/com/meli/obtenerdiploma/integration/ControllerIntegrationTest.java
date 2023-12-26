package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer;

    StudentDAO dao;

    Set<StudentDTO> originalData;

    public ControllerIntegrationTest() {
        this.writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();
        dao = new StudentDAO();
        saveJsonData();
    }

    void saveJsonData(){
        originalData = new HashSet<>();
        originalData.addAll(dao.getStudents());
    }

    /* AGREGAR TESTS CON REGISTROS INVALIDOS*/
    @Test
    @DisplayName("Register new student with valid values")
    void registerStudent() throws Exception {
        StudentDTO payload = new StudentDTO(
                3L,
                "Nombre random",
                null,
                null,
                new ArrayList<>(){{
                    add(new SubjectDTO(
                            "Matemática",
                            5.0D
                    ));
                }}
        );

        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(payload));

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        mockMvc.perform(req)
                .andDo(print())
                .andExpect(expectedStatus);
        saveData();
    }


    @Test
    @DisplayName("Get student with ID 1")
    void getStudent() throws Exception {
        StudentDTO contentResult = new StudentDTO(
                1L,
                "Juan",
                null,
                null,
                new ArrayList<>(){{
                    add(new SubjectDTO(
                            "Matemática",
                            9.0D
                    ));
                    add(new SubjectDTO(
                            "Física",
                            7.0D
                    ));
                    add(new SubjectDTO(
                            "Química",
                            6.0D
                    ));
                }}
        );

        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/student/getStudent/1");

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContent = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        System.out.println("Resultado esperado: " + writer.writeValueAsString(contentResult));
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(writer.writeValueAsString(contentResult));

        mockMvc.perform(req)
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedContent)
                .andExpect(expectedJson);
    }

    @Test
    @DisplayName("Get nonexistent student with ID 99")
    void getNonexistentStudent() throws Exception {
        ErrorDTO contentResult = new ErrorDTO("StudentNotFoundException", "El alumno con Id 99 no se encuetra registrado.");

        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/student/getStudent/99");

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher expectedContent = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(writer.writeValueAsString(contentResult));

        mockMvc.perform(req)
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedContent)
                .andExpect(expectedJson);
    }

    @Test
    @DisplayName("Modify a valid, existent student")
    void modifyStudent() throws Exception {
        StudentDTO payload = new StudentDTO(
                1L,
                "Nombre random",
                null,
                null,
                new ArrayList<>(){{
                    add(new SubjectDTO(
                            "Lengua",
                            8.0D
                    ));
                }}
        );

        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(payload));

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        mockMvc.perform(req)
                .andDo(print())
                .andExpect(expectedStatus);
    }

    @Test
    @DisplayName("Delete an existent student")
    void removeStudent() throws Exception{
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/student/removeStudent/1");

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();

        mockMvc.perform(req)
                .andDo(print())
                .andExpect(expectedStatus);
    }

    @Test
    @DisplayName("List all students")
    void listStudents() throws Exception {
        Set<StudentDTO> contentResult = new HashSet<>();
        contentResult.add(
                new StudentDTO(
                        1L,
                        "Juan",
                        null,
                        null,
                        new ArrayList<>(){{
                            add(new SubjectDTO(
                                    "Matemática",
                                    9.0D
                            ));
                            add(new SubjectDTO(
                                    "Física",
                                    7.0D
                            ));
                            add(new SubjectDTO(
                                    "Química",
                                    6.0D
                            ));
                        }}
                )
        );
        contentResult.add(
                new StudentDTO(
                        2L,
                        "Pedro",
                        null,
                        null,
                        new ArrayList<>(){{
                            add(new SubjectDTO(
                                    "Matemática",
                                    10.0D
                            ));
                            add(new SubjectDTO(
                                    "Física",
                                    8.0D
                            ));
                            add(new SubjectDTO(
                                    "Química",
                                    4.0D
                            ));
                        }}
                )
        );

        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/student/listStudents");

        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContent = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedJson = MockMvcResultMatchers.content().json(writer.writeValueAsString(contentResult));

        mockMvc.perform(req)
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedContent)
                .andExpect(expectedJson);
    }

    @AfterEach
    void saveData() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("./src/main/resources/users.json");
            objectMapper.writeValue(file, this.originalData/*.stream().toList().stream().sorted(Comparator.comparingLong(StudentDTO::getId))*/);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your JSON formatting.");
        }
    }
}
