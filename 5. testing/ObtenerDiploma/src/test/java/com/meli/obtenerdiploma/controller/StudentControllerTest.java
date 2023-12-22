package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.ValidationException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController controller;

    // Set up mocks before each test method
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Test registerStudent")
    void testRegisterStudent() {
        // Given a studentDTO
        StudentDTO studentDTO = new StudentDTO();

        // When registering a student
        ResponseEntity<?> responseEntity = controller.registerStudent(studentDTO);

        // Then verify that the 'create' method of studentService is called once with the given studentDTO
        Mockito.verify(studentService, Mockito.times(1)).create(studentDTO);
        // Also, assert that the response status code is HttpStatus.OK
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    @DisplayName("Test registerStudent with invalid data")
    void testRegisterStudentWithInvalidData() {
        // Given a studentDTO
        StudentDTO studentDTO = new StudentDTO();

        // When attempting to register a student with invalid data, throwing a ValidationException
        Mockito.doThrow(ValidationException.class).when(studentService).create(studentDTO);

        // Then assert that a ValidationException is thrown when registering the student
        assertThrows(ValidationException.class, () -> controller.registerStudent(studentDTO));
        // Also, verify that the 'create' method of studentService is called once with the given studentDTO
        Mockito.verify(studentService, Mockito.times(1)).create(studentDTO);
    }

    @Test
    @DisplayName("Test getStudent")
    void testGetStudent() {
        // Given a studentId
        Long studentId = 1L;
        // And an expected result
        StudentDTO expectedResult = new StudentDTO();
        // When retrieving a student by id
        Mockito.when(studentService.read(studentId)).thenReturn(expectedResult);

        // Then verify that the 'read' method of studentService is called once with the given studentId
        // And assert that the result matches the expected result
        StudentDTO result = controller.getStudent(studentId);
        Mockito.verify(studentService, Mockito.times(1)).read(studentId);
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Test getStudent with non-existing studentId")
    void testGetStudentNonExistingStudent() {
        // Given a non-existing studentId
        Long nonExistingStudentId = 2L;

        // When attempting to retrieve a non-existing student, returning null
        Mockito.when(studentService.read(nonExistingStudentId)).thenReturn(null);

        // Then verify that the 'read' method of studentService is called once with the given non-existing studentId
        // And assert that the result is null
        StudentDTO result = controller.getStudent(nonExistingStudentId);
        Mockito.verify(studentService, Mockito.times(1)).read(nonExistingStudentId);
        assertNull(result);
    }

    @Test
    @DisplayName("Test modifyStudent")
    void testModifyStudent() {
        // Given a studentDTO
        StudentDTO studentDTO = new StudentDTO();

        // When modifying a student
        ResponseEntity<?> responseEntity = controller.modifyStudent(studentDTO);

        // Then verify that the 'update' method of studentService is called once with the given studentDTO
        // And assert that the response status code is HttpStatus.OK
        Mockito.verify(studentService, Mockito.times(1)).update(studentDTO);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    @DisplayName("Test removeStudent")
    void testRemoveStudent() {
        // Given a studentId
        Long studentId = 1L;

        // When removing a student by id
        ResponseEntity<?> responseEntity = controller.removeStudent(studentId);

        // Then verify that the 'delete' method of studentService is called once with the given studentId
        // And assert that the response status code is HttpStatus.OK
        Mockito.verify(studentService, Mockito.times(1)).delete(studentId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    @DisplayName("Test listStudents")
    void testListStudents() {
        // Given an expected set of students
        Set<StudentDTO> expectedResult = new HashSet<>();
        // When retrieving the list of all students
        Mockito.when(studentService.getAll()).thenReturn(expectedResult);

        // Then verify that the 'getAll' method of studentService is called once
        // And assert that the result matches the expected set of students
        Set<StudentDTO> result = controller.listStudents();
        Mockito.verify(studentService, Mockito.times(1)).getAll();
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Test modifyStudent with non-existing student")
    void testModifyStudentNonExistingStudent() {
        // Given a studentDTO
        StudentDTO studentDTO = new StudentDTO();
        // When attempting to modify a non-existing student, throwing a StudentNotFoundException
        Mockito.doThrow(StudentNotFoundException.class).when(studentService).update(studentDTO);

        // Then assert that a StudentNotFoundException is thrown when modifying the student
        assertThrows(StudentNotFoundException.class, () -> controller.modifyStudent(studentDTO));
        // Also, verify that the 'update' method of studentService is called once with the given studentDTO
        Mockito.verify(studentService, Mockito.times(1)).update(studentDTO);
    }

    @Test
    @DisplayName("Test removeStudent with non-existing studentId")
    void testRemoveStudentNonExistingStudent() {
        // Given a non-existing studentId
        Long nonExistingStudentId = 2L;
        // When attempting to remove a non-existing student by id, throwing a StudentNotFoundException
        Mockito.doThrow(StudentNotFoundException.class).when(studentService).delete(nonExistingStudentId);

        // Then assert that a StudentNotFoundException is thrown when removing the student by id
        assertThrows(StudentNotFoundException.class, () -> controller.removeStudent(nonExistingStudentId));
        // Also, verify that the 'delete' method of studentService is called once with the given non-existing studentId
        Mockito.verify(studentService, Mockito.times(1)).delete(nonExistingStudentId);
    }
}