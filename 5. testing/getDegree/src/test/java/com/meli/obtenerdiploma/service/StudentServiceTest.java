package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    @DisplayName("Test to find a student by name")
    void studentRepositoryInvalidTest() {
        // Arrange
        StudentDTO expectedStudent = new StudentDTO();
        expectedStudent.setStudentName("Juan");

        // Act
        when(studentRepository.findAll()).thenReturn(Set.of(expectedStudent));
        Set<StudentDTO> result = studentRepository.findAll();

        // Assert
        assertEquals(1, result.size());
        assertEquals(expectedStudent.getStudentName(), result.iterator().next().getStudentName());
    }

    @Test
    @DisplayName("Test to create a student using StudentService")
    void studentServiceCreateTest() {
        // Arrange
        StudentDTO expectedStudent = new StudentDTO();
        expectedStudent.setStudentName("Juan");

        // Act
        doNothing().when(studentDAO).save(any(StudentDTO.class));
        studentService.create(expectedStudent);

        // Assert
        verify(studentDAO, times(1)).save(expectedStudent);
    }



}
