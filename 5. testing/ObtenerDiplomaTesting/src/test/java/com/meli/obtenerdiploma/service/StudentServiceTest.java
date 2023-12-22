package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;
    @InjectMocks
    StudentService studentService;

    @Test
    @DisplayName("Leer un estudiante")
    void readTest() {
        //Arrange
        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO subject1 = new SubjectDTO("Lengua", 6.0);
        subjects.add(subject1);
        StudentDTO student = new StudentDTO(1L, "Juan Perez", "mensaje", 8.0, subjects);

        //Act
        when(studentDAO.findById(1L)).thenReturn(student);
        StudentDTO studentReturned = studentService.read(1L);

        //Assert
        assertEquals(student, studentReturned);
    }

    @Test
    @DisplayName("Crear un estudiante")
    void createTest() {
        //Arrange
        StudentDTO studentDTO = new StudentDTO();

        //Act
        studentService.create(studentDTO);

        //Assert
        verify(studentDAO, atLeastOnce()).save(studentDTO);

    }

    @Test
    @DisplayName("Actualizar un estudiante")
    void updateTest() {
        //Arrange
        StudentDTO studentDTO = new StudentDTO();

        //Act
        studentService.update(studentDTO);

        //Assert
        verify(studentDAO, atLeastOnce()).save(studentDTO);
    }

    @Test
    @DisplayName("Eliminar un estudiante")
    void deleteTest() {
        //Arrange
        Long studentId = 1L;

        //Act
        studentService.delete(studentId);

        //Assert
        verify(studentDAO, atLeastOnce()).delete(studentId);
    }

    @Test
    @DisplayName("Listar todos los estudiastes")
    void getAllTest() {
        //Arrange
        Set<StudentDTO> students = new HashSet<>();
        StudentDTO tomi = new StudentDTO();
        StudentDTO pepe = new StudentDTO();
        students.add(tomi);
        students.add(pepe);

        //Act
        when(studentService.getAll()).thenReturn(students);
        Set<StudentDTO> studentsReturn = studentService.getAll();

        //Assert
        verify(studentRepository, atLeastOnce()).findAll();
        assertEquals(students, studentsReturn);
    }
}
