package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class StudentRepositoryTest {

    @Mock
    ResourceUtils resourceUtils;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    @DisplayName("Listar todos los alumnos")
    void findAllTest() throws FileNotFoundException {
        //Arrange

        //Act
        Set<StudentDTO> findAllReturn = studentRepository.findAll();

        //Assert
        verify(resourceUtils, atLeastOnce());
        ResourceUtils.getFile("");
        assertNotNull(findAllReturn);
    }
}
