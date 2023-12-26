package com.meli.obtenerdiploma.unitTest.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentRepositoryTest {
    @Test
    @DisplayName("Find all ok")
    void findAllOk(){
        //Arrange
        Set<StudentDTO> studentDTOSet = new HashSet<>();
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.", 7.33, List.of(
                new SubjectDTO("Matemáticas", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        ));
        studentDTOSet.add(studentDTO);
        Set<StudentDTO> expected = studentDTOSet;
        //Act
        StudentRepository studentRepository = new StudentRepository();
        Set<StudentDTO> actual = studentRepository.findAll();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    @DisplayName("Find all bad")
    void findAllBad(){
        //Arrange
        Set<StudentDTO> expected = new HashSet<>();
        //Act
        StudentRepository studentRepository = new StudentRepository();
        Set<StudentDTO> actual = studentRepository.findAll();
        //Assert
        assertEquals(expected,actual);
    }
}
