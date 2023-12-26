package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentDAOTest {

    @Autowired
    private StudentDAO studentDAO;

    @Test
    @DisplayName("Agregar un alumno")
    void saveTest(){
        //Arrange
        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO subject = new SubjectDTO("Lengua", 6.0);
        subjects.add(subject);
        StudentDTO student = new StudentDTO(1L, "Juan Perez", "mensaje", 8.0, subjects);

        //Act
        studentDAO.save(student);
        StudentDTO studentReturned = studentDAO.findById(student.getId());

        //Assert
        assertEquals(student, studentReturned);
        assertTrue(studentDAO.exists(student));
    }

    @Test
    @DisplayName("Camino triste buscar un alumno por Id")
    void findByIdTest(){
        //Arrange
        Long studentId = 2L;

        //Act - Assert
        assertThrows(StudentNotFoundException.class, ()->studentDAO.findById(studentId));
    }

    @Test
    @DisplayName("Guardar alumno")
    void testSave(){
        // Arrange
        StudentDTO studentDTO = Mockito.mock(StudentDTO.class);

        // Act
        studentDAO.save(studentDTO);

        // Assert
        assertTrue(studentDAO.exists(studentDTO));
    }

    @Test
    @DisplayName("Borrar alumno")
    void testDelete() {
        // Arrange
        StudentDTO studentDTO = Mockito.mock(StudentDTO.class);

        // Act
        studentDAO.save(studentDTO);
        boolean result = studentDAO.delete(studentDTO.getId());

        // Assert
        assertTrue(result);
        assertFalse(studentDAO.exists(studentDTO));
    }

    @Test
    @DisplayName("Que exista un alumno")
    void testExists() {
        // Arrange
        StudentDTO studentDTO = Mockito.mock(StudentDTO.class);

        // Act
        boolean result = studentDAO.exists(studentDTO);

        // Assert
        assertFalse(result);
    }

    @Test
    @DisplayName("Camino feliz buscar alumno por Id")
    void testFindById() {
        // Arrange
        StudentDTO studentDTO = Mockito.mock(StudentDTO.class);

        studentDAO.save(studentDTO);

        // Act
        StudentDTO result = studentDAO.findById(studentDTO.getId());

        // Assert
        assertNotNull(result);
        assertEquals(studentDTO.getId(), result.getId());
    }
}
