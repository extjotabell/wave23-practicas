package com.meli.obtenerdiploma;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import javax.validation.ConstraintViolationException;
import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private StudentService studentService;

    @Test
    void registerStudent_shouldReturnOk_whenStudentIsValid() throws Exception {
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        student.setStudentName("Juan");
        student.setSubjects(Arrays.asList(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)));
        Mockito.doNothing().when(studentService).create(any(StudentDTO.class));

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isOk());
    }

    @Test
    void registerStudent_shouldReturnBadRequest_whenStudentIsInvalid() throws Exception {
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        student.setStudentName(""); // Invalid student name
        student.setSubjects(Arrays.asList(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)));
        Mockito.doNothing().when(studentService).create(any(StudentDTO.class));

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getStudent_shouldReturnStudent_whenStudentExists() throws Exception {
        Long id = 1L;
        StudentDTO student = new StudentDTO();
        student.setId(id);
        student.setStudentName("Juan");
        Mockito.when(studentService.read(id)).thenReturn(student);

        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(id.intValue())))
                .andExpect(jsonPath("$.studentName", is("Juan")));
    }

    @Test
    void modifyStudent_shouldReturnOk_whenStudentIsValid() throws Exception {
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        student.setStudentName("Juan");
        student.setSubjects(Arrays.asList(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)));
        Mockito.doNothing().when(studentService).update(any(StudentDTO.class));

        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isOk());
    }

    @Test
    void modifyStudent_shouldReturnBadRequest_whenStudentIsInvalid() throws Exception {
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        student.setStudentName(""); // Invalid student name
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
        Set<StudentDTO> students = new HashSet<>();
        Mockito.when(studentService.getAll()).thenReturn(students);

        mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(students)));
    }
}
