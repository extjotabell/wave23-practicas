package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    IStudentService studentService;
    @InjectMocks
    StudentController studentController;

    @Test
    @DisplayName("StudentController - registerStudent: " +
            "Verificar que se llame service con un paramétro de tipo StudentDTO")
    void registerStudent() {
        // Arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Fernando");
        // Act
        studentController.registerStudent(stu);
        // Assert
        verify(studentService, atLeastOnce()).create(stu);
    }

    @Test
    @DisplayName("StudentController - getStudent: " +
            "Verificar que el metodo del servicio haya sido llamado y que el estudiante sea el solicitado")
    public void getStudent() {
        // Arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Fernando");
        when(studentService.read(stu.getId())).thenReturn(stu);
        // Act
        StudentDTO readStu = studentController.getStudent(stu.getId());
        // Assert
        verify(studentService, atLeastOnce()).read(stu.getId());
        assertEquals(stu, readStu);
    }

    @Test
    @DisplayName("StudentController - modifyStudent: " +
            "Verificar que el servicio sea llamado con update y el parámetro correspondiente")
    public void modifyStudent() {
        // Arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Fernando");
        studentController.modifyStudent(stu);
        // Act
        studentController.modifyStudent(stu);
        // Assert
        verify(studentService, atLeastOnce()).update(stu);
    }

    @Test
    @DisplayName("StudentController - removeStudent: " +
            "Verificar que se llame el método delete con el student id al menos una vez en el servicio")
    public void removeStudent() {
        // Arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Fernando");
        // Act
        studentController.removeStudent(stu.getId());
        // Assert
        verify(studentService, atLeastOnce()).delete(stu.getId());
    }

    @Test
    @DisplayName("StudentController - listStudents: " +
            "Verificar que se retorne el conjunto asignado de estudiantes")
    public void listStudents(){
        // Arrange
        Set<StudentDTO> students = TestUtilsGenerator.getStudentSet();
        when(studentService.getAll()).thenReturn(students);
        // Act
        Set<StudentDTO> readStudents = studentController.listStudents();
        // Assert
        verify(studentService, atLeastOnce()).getAll();
        assertTrue(CollectionUtils.isEqualCollection(students, readStudents));
    }

}
