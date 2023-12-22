package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@TestPropertySource(properties = {"api.scope=test"})
public class StudentRepositoryTest {

    @Autowired
    private IStudentRepository studentRepository;

    @Test
    @DisplayName("Test to find a student by name")
    void studentRepositoryInvalidTest() {
        // Arrange
        StudentDTO expectedStudent = new StudentDTO();
        expectedStudent.setStudentName("Juan");

        // Act
        Set<StudentDTO> result = studentRepository.findAll();

        // Assert
        assertEquals(1, result.size());
        assertEquals(expectedStudent.getStudentName(), result.iterator().next().getStudentName());
    }

    @Test
    @DisplayName("Test to null case")
    void findAllNullCaseTest() {
        // Act
        Set<StudentDTO> result = studentRepository.findAll();

        // Assert
        assertNotNull(result, "El resultado no debería ser nulo");
    }

    @Test
    @DisplayName("Test to empty case")
    void findAllEmptyCaseTest() {
        // Act
        Set<StudentDTO> result = studentRepository.findAll();

        // Assert
        assertTrue(result.isEmpty(), "El resultado debería estar vacío");
    }

    @Test
    @DisplayName("Test para invalid case")
    void findAllInvalidCaseTest() {
        // Act
        Set<StudentDTO> result = studentRepository.findAll();

        // Assert
        assertFalse(result.stream().anyMatch(student -> student.getStudentName() == null),
                "El resultado no debería contener estudiantes con nombre nulo");
    }
}
