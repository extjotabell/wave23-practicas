package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    @DisplayName("Register Student OK status")
    void registerStudentShouldReturnOkStatus(){
        //Arrange
        StudentDTO studentDTO = new StudentDTO();
        ResponseEntity<?> responseEntityExpected = new ResponseEntity<>(null, HttpStatus.OK);

        //Act
        ResponseEntity<?> result = studentController.registerStudent(studentDTO);

        // Assert
        assertEquals(responseEntityExpected.getBody(), result.getBody());
        assertEquals(responseEntityExpected.getStatusCode(), result.getStatusCode());

    }

    @Test
    @DisplayName("Get Student By Id")
    void getStudentShouldReturnOkStatus(){
        //Arrange
        StudentDTO studentDTO = new StudentDTO();
        when(studentService.read(1L)).thenReturn(studentDTO);
        //Act
        StudentDTO result = studentController.getStudent(1L);

        // Assert
        assertEquals(studentDTO, result);
        verify(studentService,times(1)).read(1L);
    }

    @Test
    @DisplayName("Modify Student OK status")
    void modifyStudentShouldReturnOkStatus(){
        //Arrange
        StudentDTO studentDTO = new StudentDTO();
        ResponseEntity<?> responseEntityExpected = new ResponseEntity<>(null, HttpStatus.OK);

        //Act
        ResponseEntity<?> result = studentController.modifyStudent(studentDTO);

        // Assert
        assertEquals(responseEntityExpected.getBody(), result.getBody());
        assertEquals(responseEntityExpected.getStatusCode(), result.getStatusCode());

    }

    @Test
    @DisplayName("Delete Student OK status")
    void deleteStudentShouldReturnOkStatus(){
        //Arrange
        ResponseEntity<?> responseEntityExpected = new ResponseEntity<>(null, HttpStatus.OK);

        //Act
        ResponseEntity<?> result = studentController.removeStudent(1L);

        // Assert
        assertEquals(responseEntityExpected.getBody(), result.getBody());
        assertEquals(responseEntityExpected.getStatusCode(), result.getStatusCode());

    }

    @Test
    @DisplayName("Get List of students")
    void listStudentstShouldReturnlistOfStudents(){
        //Act
        Set<StudentDTO> expectedList = new HashSet<>(List.of(new StudentDTO(), new StudentDTO()));
        when(studentService.getAll()).thenReturn(expectedList);

        //Act
        Set<StudentDTO> result = studentController.listStudents();

        // Assert
        assertEquals(expectedList, result);
        verify(studentService, times(1)).getAll();

    }
}