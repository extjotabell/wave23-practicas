package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    @DisplayName("Test modifyStudent")
    void modifyStudentTest() {
        // Arrange
        StudentDTO studentToModify = new StudentDTO();
        studentToModify.setId(1L);
        studentToModify.setStudentName("New Name");

        // Act
        ResponseEntity<?> response = studentController.modifyStudent(studentToModify);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        Mockito.verify(studentService, Mockito.times(1)).update(studentToModify);
    }
}
