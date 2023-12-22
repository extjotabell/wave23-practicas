package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Set;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;
    @Test
    public void findAllNotEmptyTest(){
        Set<StudentDTO> result = studentRepository.findAll();
        assertNotEquals(result.size(), 0);
    }
    @Test
    public void findAllNotNullTest(){
        Set<StudentDTO> result = studentRepository.findAll();
        assertNotNull(result);
    }

}
