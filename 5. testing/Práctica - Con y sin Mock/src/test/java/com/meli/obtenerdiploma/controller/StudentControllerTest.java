package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    @DisplayName("Registrar un usuario")
    void registerStudentOKTest(){
        //Arrange
        StudentDTO student = Mockito.mock(StudentDTO.class);
        
        //Act
        ResponseEntity<?> expectedResponse = studentController.registerStudent(student);

        //Assert
        verify(studentService, atLeastOnce()).create(any());
        assertEquals(expectedResponse, ResponseEntity.ok().body(null));
    }
}
