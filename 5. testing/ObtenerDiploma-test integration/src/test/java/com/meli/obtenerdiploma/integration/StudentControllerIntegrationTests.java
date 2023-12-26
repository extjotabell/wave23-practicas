package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
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

    // @GetMapping("/getStudent/{id}")
    //    public StudentDTO getStudent(@PathVariable Long id) {
    //        return this.studentService.read(id);
    //    }

    @Test
    @DisplayName("POST ENDPOINT: Register invalid student.")
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
                .andExpect(jsonPath("$.subjects[?(@.name == \""+"Lengua"+"\"  && @.score == "+9.0+")]").exists())
                .andExpect(jsonPath("$.subjects[?(@.name == \""+"Física"   +"\"  && @.score == "+10.0+")]").exists());

    }


}
