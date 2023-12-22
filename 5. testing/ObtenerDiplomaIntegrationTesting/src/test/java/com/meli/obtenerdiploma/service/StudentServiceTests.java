package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
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
public class StudentServiceTests {

    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepo;

    @InjectMocks
    StudentService service;

    @Test
    @DisplayName("StudentService - create: Verificar que se llame el metodo del mock repo.")
    public void createStudent() {
        // Arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Fernando");
        // Act
        service.create(stu);
        // Assert
        verify(studentDAO, atLeastOnce()).save(stu);
    }

    @Test
    @DisplayName("StudentService - read: Verificar que se devuelva el estudiante correspondiente.")
    public void readStudent() {
        // Arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Fernando");
        when(studentDAO.findById(stu.getId())).thenReturn(stu);
        // Act
        StudentDTO readStu = service.read(stu.getId());
        // Assert
        verify(studentDAO, atLeastOnce()).findById(stu.getId());
        assertEquals(stu, readStu);
    }

    @Test
    @DisplayName("StudentService - create: Verificar que se llame el metodo del mock repo 'save'.")
    public void updateStudent() {
        // Arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Fernando");
        // Act
        service.update(stu);
        // Assert
        verify(studentDAO, atLeastOnce()).save(stu);
    }

    @Test
    @DisplayName("StudentService - delete: Verificar que se llame el metodo del mock repo 'delete'.")
    public void deleteStudent() {
        // Arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Fernando");
        // Act
        service.delete(stu.getId());
        // Assert
        verify(studentDAO, atLeastOnce()).delete(stu.getId());
    }

    @Test
    @DisplayName("StudentService - getAll: " +
            "Verificar que se llame el método del mock repo 'findAll' y que la lista de estudiantes corresponda con " +
            "la lista de estudiantes cargada.")
    public void getAllStudents() {
        // Arrange
        Set<StudentDTO> students = TestUtilsGenerator.getStudentSet();
        when(studentRepo.findAll()).thenReturn(students);
        // Act
        Set<StudentDTO> readStudents = service.getAll();
        // Assert
        verify(studentRepo, atLeastOnce()).findAll();
        assertTrue(CollectionUtils.isEqualCollection(students, readStudents));
    }
}