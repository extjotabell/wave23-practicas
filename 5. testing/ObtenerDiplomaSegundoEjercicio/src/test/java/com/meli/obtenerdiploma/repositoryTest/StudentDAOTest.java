package com.meli.obtenerdiploma.repositoryTest;

import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentDAOTest {

    @Autowired
    private IStudentRepository studentRepository;
    @Test
    @DisplayName("Verificar que el conjunto de estudiante no sea nulo")
    void findAllNullTest(){
        Assertions.assertNotNull(studentRepository.findAll());
    }

}
