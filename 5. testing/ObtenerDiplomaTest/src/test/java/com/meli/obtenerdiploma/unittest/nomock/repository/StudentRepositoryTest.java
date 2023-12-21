package com.meli.obtenerdiploma.unittest.nomock.repository;

import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private IStudentRepository studentRepository;
    @Test
    @DisplayName("Verificar que el conjunto de estudiante no sea nulo")
    void findAllNullTest(){
        Assertions.assertNotNull(studentRepository.findAll());
    }

    @Test
    @DisplayName("Verificar que el conjunto de estudiantes no sea vacío")
    void findAllNotEmptyTest() {
        int studentsSize = studentRepository.findAll().size();
        int notExpectedSize = 0;
        Assertions.assertNotEquals(notExpectedSize, studentsSize);
    }
}
