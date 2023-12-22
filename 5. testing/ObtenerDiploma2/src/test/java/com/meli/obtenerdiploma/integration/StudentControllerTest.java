package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;
    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

    }

    @Autowired
    StudentDAO studentDAO;
    @BeforeEach
    public void beforeEach() {
        SubjectDTO patin = new SubjectDTO("Patin", 10.0);
        SubjectDTO danza = new SubjectDTO("Danza", 8.0);
        SubjectDTO pintura = new SubjectDTO("Pintura",6.0);

        StudentDTO student = new StudentDTO(1L, "Joaqui",null, null,
                List.of(patin, danza, pintura) );

        if( ! studentDAO.exists( student ) )
            studentDAO.save( student );
    }

    @Test
    void registerStudent_OKTest() throws Exception {
        //Arrange
        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO subject1 = new SubjectDTO("Lengua", 6.0);
        subjects.add(subject1);
        StudentDTO student = new StudentDTO(2L, "Juan Perez",
                null, null, subjects);

        String studentJson = writer.writeValueAsString(student);
        System.out.println(studentJson);

        //Act y Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentJson))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void registerStudentWithInvalidName_BadRequestTest() throws Exception {
        //Arrange
        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO subject1 = new SubjectDTO("Lengua", 6.0);
        subjects.add(subject1);
        StudentDTO student = new StudentDTO(2L, "juanita perez",
                null, null, subjects);

        String studentJson = writer.writeValueAsString(student);
        System.out.println(studentJson);

        //Act y Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value("El nombre del estudiante debe comenzar con mayúscula."));;


    }
    @Test
    void registerStudentWithNoSubjects_BadRequestTest() throws Exception {
        //Arrange
        StudentDTO student = new StudentDTO(2L, "Pepe",
                null, null, null);

        String studentJson = writer.writeValueAsString(student);
        System.out.println(studentJson);

        //Act y Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description").value("La lista de materias no puede estar vacía."));;


    }
    @Test
    void getStudent_OkTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student//getStudent/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.studentName").value("Joaqui"))
                .andExpect(jsonPath("$.subjects").isNotEmpty());
    }

    @Test
    void getStudent_NotFoundTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student//getStudent/{id}", 20))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"))
                .andExpect(jsonPath("$.description").value("El alumno con Id 20 no se encuentra registrado."));
    }

    
}
