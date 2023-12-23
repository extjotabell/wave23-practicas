package com.meli.obtenerdiploma.Integrations;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegralTest {

    private static final String TEST_JSON_FILE_PATH = "src/test/resources/users.json";
    private static final String MAIN_JSON_FILE_PATH = "src/main/resources/users.json";

    @BeforeClass
    @BeforeEach
    public void globalSetup() throws IOException {
        // Copiar el archivo JSON original a una ubicación temporal antes de cada prueba.
        FileUtils.copyFile(Paths.get(MAIN_JSON_FILE_PATH).toFile(), Paths.get(TEST_JSON_FILE_PATH).toFile());
    }


    @Autowired
    MockMvc mockMvc;

    @Test
    void registerStudentTestOk() throws Exception {
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        StudentDTO payloadDTO = new StudentDTO(1L, "Juan",
                                               "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.",
                                               7.333333333333333,
                                               List.of(new SubjectDTO("Matematica", 9.0), new SubjectDTO("Fisica", 7.0),
                                                       new SubjectDTO("Quimica", 6.0)));

        String payloadJSON = writer.writeValueAsString(payloadDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent").contentType(MediaType.APPLICATION_JSON)
                                              .content(payloadJSON)).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void registerStudentTestNonOk() throws Exception {
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        StudentDTO payloadDTO = new StudentDTO(1L, "auan",
                                               "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.",
                                               7.333333333333333, null);

        String payloadJSON = writer.writeValueAsString(payloadDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent").contentType(MediaType.APPLICATION_JSON)
                                              .content(payloadJSON)).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    void getStudentTestOk() throws Exception {
        mockMvc.perform(get("/student/getStudent/{id}", 1L)).andDo(print()).andExpect(status().isOk())
               .andExpect(jsonPath("$.id").value(1L));

    }

    @Test
    void getStudentTestNonOk() throws Exception {
        mockMvc.perform(get("/student/getStudent/{id}", -1L)).andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    void modifyStudentTestOk() throws Exception {
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        StudentDTO payloadDTO = new StudentDTO(1L, "Marcos",
                                               "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.",
                                               7.333333333333333,
                                               List.of(new SubjectDTO("Matematica", 9.0), new SubjectDTO("Fisica", 7.0),
                                                       new SubjectDTO("Quimica", 6.0)));

        String payloadJSON = writer.writeValueAsString(payloadDTO);
        mockMvc.perform(post("/student/modifyStudent").contentType(MediaType.APPLICATION_JSON).content(payloadJSON))
               .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void modifyStudentTestNonOkInvalidFields() throws Exception {
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        StudentDTO payloadDTO = new StudentDTO(1L, "aarcos",
                                               "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.",
                                               7.333333333333333,
                                               List.of(new SubjectDTO("matematica", 9.0), new SubjectDTO("Fisica", 7.0),
                                                       new SubjectDTO("Quimica", 6.0)));

        String payloadJSON = writer.writeValueAsString(payloadDTO);
        mockMvc.perform(post("/student/modifyStudent").contentType(MediaType.APPLICATION_JSON).content(payloadJSON))
               .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    void modifyStudentTestNonOkNotFound() throws Exception {
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        StudentDTO payloadDTO = new StudentDTO(-1L, "aarcos",
                                               "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.",
                                               7.333333333333333,
                                               List.of(new SubjectDTO("matematica", 9.0), new SubjectDTO("Fisica", 7.0),
                                                       new SubjectDTO("Quimica", 6.0)));

        String payloadJSON = writer.writeValueAsString(payloadDTO);
        mockMvc.perform(post("/student/modifyStudent").contentType(MediaType.APPLICATION_JSON).content(payloadJSON))
               .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    void removeStudentTestOk() throws Exception {
        mockMvc.perform(get("/student/removeStudent/{id}", 1L)).andExpect(status().isOk());
    }


    @Test
    void listStudentsTest() throws Exception {

        MvcResult result = mockMvc.perform(get("/student/listStudents")).andExpect(status().isOk()).andReturn();
        ObjectMapper objectMapper = new ObjectMapper();
        Set<StudentDTO> studentList = new HashSet<>();
        try {
            // Parsear el string JSON a una lista de StudentDTO
            studentList = objectMapper.readValue(result.getResponse().getContentAsString(),
                                                 new TypeReference<Set<StudentDTO>>() {
                                                 });
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assertions.assertTrue(studentList.stream().anyMatch(studentDTO -> studentDTO.getId()==2L));
    }
}
