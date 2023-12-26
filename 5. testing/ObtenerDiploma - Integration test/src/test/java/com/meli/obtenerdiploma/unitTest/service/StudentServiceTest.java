package com.meli.obtenerdiploma.unitTest.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    @DisplayName("Create ok")
    void createOk() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", "Message", 9.23, null);

        // Act
        studentService.create(studentDTO);

        // Assert
        verify(studentDAO, times(1)).save(studentDTO);
    }

    @Test
    @DisplayName("Read ok")
    void readOk() {
        // Arrange
        long studentId = 1L;
        StudentDTO expectedStudentDTO = new StudentDTO(studentId, "Juan", "Message", 9.23, null);
        when(studentDAO.findById(studentId)).thenReturn(expectedStudentDTO);

        // Act
        StudentDTO result = studentService.read(studentId);

        // Assert
        assertEquals(expectedStudentDTO, result);
    }

    @Test
    @DisplayName("Update ok")
    void updateOk() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", "Message", 9.23, null);

        // Act
        studentService.update(studentDTO);

        // Assert
        verify(studentDAO, times(1)).save(studentDTO);
    }

    @Test
    @DisplayName("Delete by id ok")
    void deleteById() {
        // Arrange
        long studentId = 1L;

        // Act
        studentService.delete(studentId);

        // Assert
        verify(studentDAO, times(1)).delete(studentId);
    }

    @Test
    @DisplayName("getAll should return all students")
    void getAllShouldReturnAllStudents() {
        // Arrange
        Set<StudentDTO> expectedStudents = new HashSet<>();
        expectedStudents.add(new StudentDTO(1L, "Juan", "Message", 9.23, null));
        expectedStudents.add(new StudentDTO(2L, "Pedro", "Message", 8.5, null));
        when(studentRepository.findAll()).thenReturn(expectedStudents);

        // Act
        Set<StudentDTO> result = studentService.getAll();

        // Assert
        assertEquals(expectedStudents, result);
    }
}
