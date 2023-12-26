package com.meli.obtenerdiploma.Integrations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// Annotate the class for Spring Boot testing
@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerIntegrationTest {

    // Autowire necessary components
    @Autowired
    private MockMvc mockMvc;

    // Create an ObjectWriter with specified serialization settings
    private final ObjectWriter objecTWriter = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

    @Test
    @DisplayName("Test case for registering a student successfully")
    void registerStudentOk() throws Exception {
        // Create a student DTO
        StudentDTO responseDTO = createStudentDTO(3L, "Arami");

        // Convert student DTO to JSON
        String payloadJson = this.objecTWriter.writeValueAsString(responseDTO);

        // Perform a POST request to register the student and expect an OK response
        this.mockMvc.perform(post("/student/registerStudent")
                        .contentType("application/json")
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    @DisplayName("Test case for attempting to register a student with invalid data")
    void registerStudentNoOk() throws Exception {
        // Create a student DTO with null values
        StudentDTO responseDTO = createStudentDTO(null, null);

        // Convert student DTO to JSON
        String payloadJson = this.objecTWriter.writeValueAsString(responseDTO);

        // Perform a POST request to register the student and expect a client error response
        this.mockMvc.perform(post("/student/registerStudent")
                        .contentType("application/json")
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    @DisplayName("Test case for getting a student successfully")
    void getStudentOk() throws Exception {
        // Create a student DTO
        StudentDTO studentDTO = createStudentDTO(1L, "Juan");

        // Convert student DTO to JSON
        String payloadJson = this.objecTWriter.writeValueAsString(studentDTO);

        // Perform a GET request to retrieve the student and expect an OK response
        MvcResult result = this.mockMvc.perform(get("/student/getStudent/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        // Verify that the correct student is returned
        assertEquals(payloadJson, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("Test case for attempting to get a non-existent student")
    void getStudentNoOk() throws Exception {
        // Define expected exception details
        String name = "StudentNotFoundException";
        String description = "El alumno con Id 100 no se encuetra registrado.";

        // Perform a GET request for a non-existent student and expect a client error response
        this.mockMvc.perform(get("/student/getStudent/{id}", 100L))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.description").value(description))
                .andReturn();
    }

    @Test
    @DisplayName("Test case for modifying a student successfully")
    void modifyStudentOk() throws Exception {
        // Create a student DTO
        StudentDTO studentDTO = createStudentDTO(1L, "Juan");

        // Modify the student
        studentDTO.setStudentName("Updated Name");

        // Convert modified student DTO to JSON
        String payloadJson = this.objecTWriter.writeValueAsString(studentDTO);

        // Perform a POST request to modify the student and expect an OK response
        this.mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test case for attempting to modify a student with invalid data")
    void modifyStudentNoOk() throws Exception {
        // Define expected exception details
        String exceptionName = "MethodArgumentNotValidException";
        String description = "El nombre del estudiante no puede estar vacío.";

        // Create a student DTO with null values
        StudentDTO studentDTO = createStudentDTO(null, null);

        // Modify the student with invalid data
        studentDTO.setStudentName(null);

        // Convert modified student DTO to JSON
        String payloadJson = this.objecTWriter.writeValueAsString(studentDTO);

        // Perform a POST request to modify the student and expect a client error response
        this.mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.name").value(exceptionName))
                .andExpect(jsonPath("$.description").value(description));
    }

    @Test
    @DisplayName("Test case for removing a student successfully")
    void removeStudentOk() throws Exception {
        // Create a student DTO
        StudentDTO studentDTO = createStudentDTO(2L, "Pedro");

        // Perform a GET request to remove the student and expect an OK response
        this.mockMvc.perform(get("/student/removeStudent/{id}", studentDTO.getId()))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test case for listing students")
    void listStudents() throws Exception {
        // Create multiple students
        StudentDTO student1 = createStudent2DTO(2L, "Pedro");
        StudentDTO student2 = createStudentDTO(1L, "Juan");

        // Convert list of students to JSON
        List<StudentDTO> studentsDTO = List.of(student1, student2);

        ObjectWriter objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = objectWriter.writeValueAsString(studentsDTO);

        // Perform a GET request to list students and expect an OK response
        MvcResult result = this.mockMvc.perform(get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        // Verify that the correct list of students is returned
        assertEquals(payloadJson, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    // Helper method to create a student DTO with specified ID and name
    private StudentDTO createStudentDTO(Long id, String name) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(id);
        studentDTO.setStudentName(name);

        // Create a list of SubjectDTO with at least one element
        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Matemática");
        subjectDTO.setScore(9.0);
        subjects.add(subjectDTO);

        SubjectDTO subjectDTO2 = new SubjectDTO();
        subjectDTO2.setName("Física");
        subjectDTO2.setScore(7.0);
        subjects.add(subjectDTO2);

        SubjectDTO subjectDTO3 = new SubjectDTO();
        subjectDTO3.setName("Química");
        subjectDTO3.setScore(6.0);
        subjects.add(subjectDTO3);

        studentDTO.setSubjects(subjects);
        return studentDTO;
    }

    // Helper method to create a second student DTO with specified ID and name
    private StudentDTO createStudent2DTO(Long id, String name) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(id);
        studentDTO.setStudentName(name);

        // Create a list of SubjectDTO with at least one element
        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Matemática");
        subjectDTO.setScore(10.0);
        subjects.add(subjectDTO);

        SubjectDTO subjectDTO2 = new SubjectDTO();
        subjectDTO2.setName("Física");
        subjectDTO2.setScore(8.0);
        subjects.add(subjectDTO2);

        SubjectDTO subjectDTO3 = new SubjectDTO();
        subjectDTO3.setName("Química");
        subjectDTO3.setScore(4.0);
        subjects.add(subjectDTO3);

        studentDTO.setSubjects(subjects);
        return studentDTO;
    }
}
