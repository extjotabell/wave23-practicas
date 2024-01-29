package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentRepositoryTest {
    ObjectWriter writer = new ObjectMapper().
            configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();

    StudentRepository repository = new StudentRepository();

    @DisplayName("Test del metodo del repositorio")
    @Test
    public void findAll() throws JsonProcessingException {
        //ARRANGE
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matemática",9.00));
        subjectDTOList.add(new SubjectDTO("Física",7.00));
        subjectDTOList.add(new SubjectDTO("Química",6.00));
        StudentDTO alumno = new StudentDTO(1L,"Juan",null,null,subjectDTOList);

        Set<StudentDTO> expected = new HashSet<>();
        expected.add(alumno);

        //ACT
        Set<StudentDTO> obtain = repository.findAll();

        //ASSERT
        assertEquals(writer.writeValueAsString(expected),writer.writeValueAsString(obtain));
    }
}