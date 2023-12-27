package com.meli.obtenerdiploma.unittest.controller;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController controller;

    @Test
    void registerStudentTest() {
        // Arrange
        StudentDTO student = new StudentDTO();
        student.setStudentName("Marcos");
        student.setSubjects(List.of(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Química", 10.0),
                new SubjectDTO("Física", 10.0)
        ));

        // Act
        studentService.create(student);

        // Assert
        verify(studentService, times(1)).create(student);
    }

    @Test
    void getStudentTest() {
        // Arrange
        StudentDTO student = new StudentDTO();
        student.setStudentName("Marcos");
        student.setSubjects(List.of(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Química", 10.0),
                new SubjectDTO("Física", 10.0)
        ));

        when(studentService.read(student.getId())).thenReturn(student);

        // Act
        StudentDTO actual = studentService.read(student.getId());

        // Assert
        assertEquals(student.getStudentName(), actual.getStudentName());
    }

    @Test
    void removeStudentTest() {
        // Arrange
        StudentDTO student = new StudentDTO();
        student.setStudentName("Marcos");
        student.setSubjects(List.of(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Química", 10.0),
                new SubjectDTO("Física", 10.0)
        ));

        // Act
        studentService.delete(student.getId());

        // Assert
        verify(studentService, times(1)).delete(student.getId());
    }

}
