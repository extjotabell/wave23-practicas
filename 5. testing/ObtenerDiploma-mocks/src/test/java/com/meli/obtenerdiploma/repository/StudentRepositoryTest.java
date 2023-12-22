package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;


@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    @DisplayName("Encontrar todos los alumnos")
    void testFindAll(){
        //Arrange
        Set<StudentDTO> result;
        //Act
        result = studentRepository.findAll();
        // Assert
        assertNotNull(result);
    }
}
