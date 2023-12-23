package com.meli.obtenerdiploma.controllers;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class StudentControllerTest {

    @Mock
    IStudentService service;
    @InjectMocks
    StudentController controller;

    @Test
    void registerStudentTest() {
        //Arrange
        StudentDTO dto = new StudentDTO();
        //Act
        ResponseEntity result = controller.registerStudent(dto);
        //Assert
        verify(service).create(dto);
        Assertions.assertEquals(200,result.getStatusCodeValue());
    }

    @Test
    void getStudentTest() {
        //Arrange
        Long id = 1L;
        StudentDTO dto = new StudentDTO();
        when(controller.getStudent(id)).thenReturn(dto);
        //Act
        StudentDTO result = controller.getStudent(id);
        //Assert
        verify(service).read(id);
        assertEquals(dto, result);
    }

    @Test
    void modifyStudentTest() {
        //Arrange
        StudentDTO dto = new StudentDTO();
        //Act
        ResponseEntity result = controller.modifyStudent(dto);
        //Assert
        verify(service).update(dto);
        assertEquals(result.getStatusCodeValue(),200);
    }

    @Test
    void removeStudent() {
        //Arrange
        Long id = 1L;
        //Act
        ResponseEntity result =controller.removeStudent(id);
        //Assert
        verify(service).delete(id);
        assertEquals(result.getStatusCodeValue(),200);
    }

    @Test
    void listStudents() {
        //Arrange
        Set<StudentDTO> studentsExpected = new HashSet<>();
        when(controller.listStudents()).thenReturn(studentsExpected);
        //Act
        Set<StudentDTO> result = controller.listStudents();
        //Assert
        verify(service).getAll();
        assertEquals(result,studentsExpected);
    }


}
