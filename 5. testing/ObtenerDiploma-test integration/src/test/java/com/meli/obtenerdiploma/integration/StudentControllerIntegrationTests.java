package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    private StudentDTO studentDTO;

    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    public void beforEach() {
        //Arrange
        studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        studentDTO.setId(1L);
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
    }

    @Test
    @DisplayName("POST ENDPOINT: Register student.")
    void registerStudentValidDataShouldReturnOk() throws Exception {
        //Arrange
        String payloadJSON = writer.writeValueAsString(studentDTO);
        //Act - Assert
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());

        studentDAO.delete(1L);
    }

    @Test
    @DisplayName("POST ENDPOINT: Register invalid student.")
    void registerStudentInvalidDataShouldReturnExceptions() throws Exception {
        //Arrange
        StudentDTO studentDTOInvalid = new StudentDTO();
        String payloadJSON = writer.writeValueAsString(studentDTOInvalid);
        //Act - Assert
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(status().isBadRequest());
    }
    @Test
    @DisplayName("POST ENDPOINT: Register invalid student with invalid json format.")
    void registerStudentInvalidFormatShouldReturnExceptions() throws Exception {
        //Arrange
        String payloadJSON ="";
        String expectedMessage= "Required request body is missing: public org.springframework.http.ResponseEntity<?> " +
                                "com.meli.obtenerdiploma.controller.StudentController.registerStudent" +
                                "(com.meli.obtenerdiploma.model.StudentDTO)";
        //Act - Assert
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/student/registerStudent")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payloadJSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("$.name").value("HttpMessageNotReadableException"))
                .andExpect(jsonPath("$.description").value(expectedMessage))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("GET ENDPOINT: Get student by id - valid id.")
    void getStudentByExistingIdShouldReturnStudentDTO() throws Exception {
        //Arrange
        studentDAO.save(studentDTO);
        //Act - Assert
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/student/getStudent/{id}", 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.studentName").value("Marco"))
                .andExpect(jsonPath("$.subjects.length()").value(3))
                .andExpect(jsonPath("$.subjects[?(@.name == \""+"Matemática"+"\"  && @.score == "+8.0+")]").exists())
                .andExpect(jsonPath("$.subjects[?(@.name == \""+"Lengua"+"\"  && @.score == "+6.0+")]").exists())
                .andExpect(jsonPath("$.subjects[?(@.name == \""+"Física"   +"\"  && @.score == "+4.0+")]").exists());
        studentDAO.delete(1L);
    }
    @Test
    @DisplayName("GET ENDPOINT: Get student by id - invalid id.")
    void getStudentByInvalidIdShouldReturnException() throws Exception {
        //Act - Assert
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/student/getStudent/{id}", 1890))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("POST ENDPOINT: Modify valid student.")
    void modifyStudentValidDataShouldReturnOk() throws Exception {
        //Arrange
        studentDAO.save(studentDTO);

        StudentDTO modifyStudentDTO = new StudentDTO();
        modifyStudentDTO.setId(studentDTO.getId());
        modifyStudentDTO.setStudentName(studentDTO.getStudentName());
        modifyStudentDTO.setSubjects(studentDTO.getSubjects());
        modifyStudentDTO.getSubjects().add(new SubjectDTO("POOB", 7.0));

        String payloadJSON = writer.writeValueAsString(modifyStudentDTO);

        //Act - Assert
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/student/modifyStudent")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payloadJSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());

        studentDAO.delete(1L);
    }

    @Test
    @DisplayName("DELETE ENDPOINT: Delete student by id - valid id.")
    void deleteStudentByExistingIdShouldReturnStatusOk() throws Exception {
        //Arrange
        studentDAO.save(studentDTO);
        //Act - Assert
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/student/removeStudent/{id}", 1))
                .andDo(MockMvcResultHandlers.print())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET ENDPOINT: List of students.")
    void listStudentsReturnListAndStatusOk() throws Exception {
        //Arrange
        studentDAO.save(studentDTO);

        //Act - Assert
        this.mockMvc.perform(
                      MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(MockMvcResultHandlers.print())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("$", hasSize(greaterThan(0))))
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk());

        studentDAO.delete(1L);
    }

}
