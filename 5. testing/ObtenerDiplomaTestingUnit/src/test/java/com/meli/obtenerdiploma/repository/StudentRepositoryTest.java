package com.meli.obtenerdiploma.repository;


import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    StudentRepository repository;

    @Test
    @DisplayName("Test to empty case")
    void findAllEmptyCase(){
        Set<StudentDTO> result = repository.findAll();
        assertFalse(result.isEmpty(), "El resultado deberia estar vacio");
    }

    @Test
    @DisplayName("Test to invalid case")
    void findAllInvalidCase(){
        Set<StudentDTO> result = repository.findAll();
        assertFalse(result.stream().anyMatch(studentDTO -> studentDTO.getStudentName()==null), "El resultado no deberia contener students con el nombre nulo");
    }

    @Test
    @DisplayName("Test to null case")
    void findAllNullCase(){
        Set<StudentDTO> result = repository.findAll();
        assertNotNull(result, "El resultado no deberia ser nulo");
    }
    @Test
    @DisplayName("Test to invalid case")
    void findAllExceptionCase(){
        //arrange
        repository.setUri("hola");

        //act
        Set<StudentDTO> expected = new HashSet<>();
        //assert
        Assertions.assertEquals(expected, repository.findAll());
        repository.setUri(repository.getURI());
    }
    @Test
    @DisplayName("Test to exception find all case")
    void findAllExceptionBadFormarCase(){
        //arrange
        repository.setUri("resources/usersBadFormat.json");
        //act
        Set<StudentDTO> expected = new HashSet<>();
        //assert
        Assertions.assertEquals(expected, repository.findAll());
        repository.setUri(repository.getURI());

    }
}
