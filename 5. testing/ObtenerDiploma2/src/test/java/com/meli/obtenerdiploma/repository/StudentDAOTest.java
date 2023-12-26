package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class StudentDAOTest {

    StudentDAO studentDAO = new StudentDAO();

    ObjectWriter writer = new ObjectMapper().
            configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();


    @DisplayName("Test de eliminar un alumno en StudentDAO (Success)")
    @Test
    public void delete(){
        //ARRANGE
        Long id = 1L;
        boolean expected = true;

        //ACT && ASSERT
        assertEquals(expected,studentDAO.delete(id));
    }

    @DisplayName("Test de guardar un alumno en StudentDAO (Success)")
    @Test
    public void save(){
        //ARRANGE
        StudentDAO mock = mock(StudentDAO.class);

        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática",9.00));
        subjectDTOList.add(new SubjectDTO("Física",7.00));
        subjectDTOList.add(new SubjectDTO("Química",6.00));
        StudentDTO expected = new StudentDTO(1L,"Juan",null,null,subjectDTOList);

        //ACT
        mock.save(expected);

        //ASSERT
        verify(mock, atLeastOnce()).save(expected);
    }

    @DisplayName("Test de eliminar un alumno en StudentDAO (Error)")
    @Test
    public void deleteError(){
        //ARRANGE
        Long id = 100L;
        boolean expected = false;

        //ACT && ASSERT
        assertEquals(expected,studentDAO.delete(id));
    }

    @DisplayName("Test de comprobar la existencia de un alumno StudentDAO (Success)")
    @Test
    public void exists(){
        //ARRANGE
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática",9.00));
        subjectDTOList.add(new SubjectDTO("Física",7.00));
        subjectDTOList.add(new SubjectDTO("Química",6.00));
        StudentDTO test = new StudentDTO(1L,"Juan",null,null,subjectDTOList);
        boolean expected = true;

        //ACT
        boolean obtain = studentDAO.exists(test);

        //ASSERT
        assertEquals(expected,obtain);
    }

    @DisplayName("Test de comprobar la existencia de un alumno StudentDAO (Exception)")
    @Test
    public void existsException(){
        //ARRANGE
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática",9.00));
        subjectDTOList.add(new SubjectDTO("Física",7.00));
        subjectDTOList.add(new SubjectDTO("Química",6.00));
        StudentDTO test = new StudentDTO(100L,"Juan",null,null,subjectDTOList);
        boolean expected = false;

        //ACT
        boolean obtain = studentDAO.exists(test);

        //ASSERT
        assertEquals(expected,obtain);
    }

    @DisplayName("Test de comprobar la existencia de un alumno StudentDAO (Success)")
    @Test
    public void findById() throws JsonProcessingException {
        //ARRANGE
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática",9.00));
        subjectDTOList.add(new SubjectDTO("Física",7.00));
        subjectDTOList.add(new SubjectDTO("Química",6.00));
        StudentDTO expected = new StudentDTO(1L,"Juan",null,null,subjectDTOList);

        //ACT
        StudentDTO obtain = studentDAO.findById(expected.getId());

        //ASSERT
        assertEquals(writer.writeValueAsString(expected),writer.writeValueAsString(obtain));
    }
}
