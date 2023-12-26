package com.meli.obtenerdiploma.integrationTest;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void registerStudentTestOk () throws Exception{
        StudentDTO entradaDto = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.", 7.333333333333333, List.of(
                new SubjectDTO("Matematicas", 9.0),
                new SubjectDTO("Fisica", 7.0),
                new SubjectDTO("Quimica", 6.0)
        ));

        ObjectWriter objecTWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String payloadJson = objecTWriter.writeValueAsString(entradaDto);

        this.mockMvc.perform(post("/student/registerStudent")
                .contentType("application/json")
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
    @Test
    void registerStudentTestNotFound () throws Exception{
        StudentDTO entradaDto = new StudentDTO(1111L, "Juan", "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.", 7.333333333333333, List.of(
                new SubjectDTO("Matematicas", 9.0),
                new SubjectDTO("Fisica", 7.0),
                new SubjectDTO("Quimica", 6.0)
        ));

        ObjectWriter objecTWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String payloadJson = objecTWriter.writeValueAsString(entradaDto);

        this.mockMvc.perform(post("/student/registerStudent")
                        .contentType("application/json")
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();
    }
    @Test
    void getStudentByIdOk() throws Exception{
        StudentDTO responseDto = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.", 7.333333333333333, List.of(
                new SubjectDTO("Matematicas", 9.0),
                new SubjectDTO("Fisica", 7.0),
                new SubjectDTO("Quimica", 6.0)
        ));

        ObjectWriter objecTWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String expected = objecTWriter.writeValueAsString(responseDto);

        MvcResult mvcResult = this.mockMvc.perform(get("/student/getStudent/{id}",1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expected,mvcResult.getResponse().getContentAsString());

    }
    @Test
    void getStudentByIdNotFound() throws Exception{
       this.mockMvc.perform(get("/student/getStudent/{id}",11L))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }
    @Test
    void modifyStudentOk() throws Exception{
        StudentDTO entradaDto = new StudentDTO(1L, "Juan Cruz", "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.", 7.333333333333333, List.of(
                new SubjectDTO("Matematicas", 9.0),
                new SubjectDTO("Fisica", 7.0),
                new SubjectDTO("Quimica", 6.0)
        ));

        ObjectWriter objecTWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String payloadJson = objecTWriter.writeValueAsString(entradaDto);

        this.mockMvc.perform(post("/student/modifyStudent")
                        .contentType("application/json")
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
    @Test
    void modifyStudentNotFound() throws Exception{
        StudentDTO entradaDto = new StudentDTO(111L, "Juan Cruz", "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.", 7.333333333333333, List.of(
                new SubjectDTO("Matematicas", 9.0),
                new SubjectDTO("Fisica", 7.0),
                new SubjectDTO("Quimica", 6.0)
        ));

        ObjectWriter objecTWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String payloadJson = objecTWriter.writeValueAsString(entradaDto);

        this.mockMvc.perform(post("/student/modifyStudent")
                        .contentType("application/json")
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();
    }
    @Test
    void removeStudentOk() throws Exception{

        this.mockMvc.perform(get("/student/removeStudent/{id}",1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
    @Test
    void removeStudentNotFound() throws Exception{

        this.mockMvc.perform(get("/student/removeStudent/{id}",11L))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();
    }
    @Test
    void listStudentsOk() throws Exception {
        Set<StudentDTO> studentDTOSet = new HashSet<>();
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.", 7.333333333333333, List.of(
                new SubjectDTO("Matematicas", 9.0),
                new SubjectDTO("Fisica", 7.0),
                new SubjectDTO("Quimica", 6.0)
        ));
        studentDTOSet.add(studentDTO);
        ObjectWriter objecTWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String expected = objecTWriter.writeValueAsString(studentDTOSet);

        MvcResult mvcResult = this.mockMvc.perform(get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        assertEquals(expected,mvcResult.getResponse().getContentAsString());
    }
}
