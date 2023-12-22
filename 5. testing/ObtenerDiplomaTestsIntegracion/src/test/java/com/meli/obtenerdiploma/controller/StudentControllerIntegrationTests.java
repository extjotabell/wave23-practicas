package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.StudentService;
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

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(StudentController.class)
class StudentControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private StudentService studentService;

    @BeforeEach
    @AfterEach
    private void setUp() {
        TestUtilsGenerator.emptyUsersFile();
    }


    @Test
    void registerStudent_shouldReturnOk_whenStudentIsValid() throws Exception {
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Valid Student");
        Mockito.doNothing().when(studentService).create(any(StudentDTO.class));

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isOk());
    }

    @Test
    void registerStudent_shouldReturnBadRequest_whenStudentIsInvalid() throws Exception {
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("");

        Mockito.doNothing().when(studentService).create(any(StudentDTO.class));

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getStudent_shouldReturnStudent_whenStudentExists() throws Exception {
        Long id = 1L;
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Existing Student");
        student.setId(id);
        when(studentService.read(id)).thenReturn(student);

        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(id.intValue())))
                .andExpect(jsonPath("$.studentName", is("Existing Student")));
    }

    @Test
    void modifyStudent_shouldReturnOk_whenStudentIsValid() throws Exception {
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Valid Student");

        Mockito.doNothing().when(studentService).update(any(StudentDTO.class));

        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isOk());
    }

    @Test
    void modifyStudent_shouldReturnBadRequest_whenStudentIsInvalid() throws Exception {
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("");

        Mockito.doNothing().when(studentService).update(any(StudentDTO.class));

        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void removeStudent_shouldReturnOk_whenStudentExists() throws Exception {
        Long id = 1L;
        Mockito.doNothing().when(studentService).delete(id);

        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", id))
                .andExpect(status().isOk());
    }

    @Test
    void listStudents_shouldReturnListOfStudentDTOs() throws Exception {
        Set<StudentDTO> students = TestUtilsGenerator.getStudentSet();
        when(studentService.getAll()).thenReturn(students);

        mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(students)));
    }

    @Test
    void listStudents_shouldReturnEmptyListWhenNoStudentsExist() throws Exception {
        when(studentService.getAll()).thenReturn(new HashSet<>());

        mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }
}
