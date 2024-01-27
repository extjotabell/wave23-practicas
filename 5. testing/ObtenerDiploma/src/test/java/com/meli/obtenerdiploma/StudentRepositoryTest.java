package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class StudentRepositoryIntegrationTest {

    @Autowired
    private StudentRepository studentRepository;

    private Set<StudentDTO> students;

    @BeforeEach
    public void setup() {
        students = new HashSet<>();
        students.add(new StudentDTO(1L, "Juan", null, null, Arrays.asList(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        )));
        students.add(new StudentDTO(2L, "Pedro", null, null, Arrays.asList(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 8.0),
                new SubjectDTO("Química", 4.0)
        )));
    }


    @Test
    void findAllReturnsAllStudents() {
        // Act
        Set<StudentDTO> result = studentRepository.findAll();

        // Assert
        assertEquals(students.size(), result.size());
    }

    @Test
    void findAllReturnsCorrectStudents() {
        // Act
        Set<StudentDTO> result = studentRepository.findAll();

        // Assert
        assertTrue(result.containsAll(students));
    }

}