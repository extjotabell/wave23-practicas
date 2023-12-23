package com.meli.obtenerdiploma.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentRepositoryTests {

    IStudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        this.studentRepository = new StudentRepository();
    }

    @Test
    @DisplayName("Find all students OK")
    void findAllStudentsOK() {
        // Act and Assert
        Assertions.assertEquals(46, studentRepository.findAll().size());
    }
}
