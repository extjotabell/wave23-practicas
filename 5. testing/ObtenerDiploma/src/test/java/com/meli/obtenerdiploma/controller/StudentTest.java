package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentTest {
    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registerStudentTest() {
        //Arrange
        StudentDTO dto = new StudentDTO();
        //Act
        ResponseEntity result = studentController.registerStudent(dto);
        //Assert
        verify(studentService).create(dto);
        Assertions.assertEquals(200,result.getStatusCodeValue());
    }

    @Test
    void getStudentTest() {
        //Arrange
        StudentDTO dto = new StudentDTO();
        dto.setId(1L);
        when(studentService.read(1L)).thenReturn(dto);
        //Act
        StudentDTO result = studentController.getStudent(1L);
        //Assert
        verify(studentService).read(1L);
        assertEquals(dto,result);
    }

    @Test
    void modifyStudentTest() {
        //Arrange
        StudentDTO dto = new StudentDTO();
        //Act
        ResponseEntity<?> result = studentController.modifyStudent(dto);
        //Assert
        verify(studentService).update(dto);
        Assertions.assertEquals(200,result.getStatusCodeValue());
    }

    @Test
    void removeStudentTest() {
        //Arrange
        //Act
        ResponseEntity<?> result = studentController.removeStudent(1L);
        //Assert
        verify(studentService).delete(1L);
        Assertions.assertEquals(200,result.getStatusCodeValue());
    }

    @Test
    void listStudentsTest() {
        //Arrange
        Set<StudentDTO> studentsExpected = new HashSet<>();
        when(studentController.listStudents()).thenReturn(studentsExpected);
        //Act
        Set<StudentDTO> result = studentController.listStudents();
        //Assert
        verify(studentService).getAll();
        assertEquals(result,studentsExpected);
    }
}
