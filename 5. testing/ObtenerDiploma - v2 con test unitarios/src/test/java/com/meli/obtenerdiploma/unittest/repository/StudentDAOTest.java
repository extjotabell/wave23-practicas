package com.meli.obtenerdiploma.unittest.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTest {

    StudentDAO studentDAO = new StudentDAO();

    @Test
    void saveTest() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Marcos");

        // Act
        studentDAO.save(studentDTO);

        // Assert
        StudentDTO found = studentDAO.findById(studentDTO.getId());
        assertEquals(studentDTO, found);
    }

    @Test
    void saveSadTest() {
        // Arrange
        StudentDTO studentToSave = new StudentDTO();
        studentToSave.setStudentName("Marcos");
        studentDAO.save(studentToSave);
        StudentDTO studentSaved = studentDAO.findById(studentToSave.getId());

        // Act
        studentDAO.save(studentSaved);

        // Assert
        StudentDTO result = studentDAO.findById(studentSaved.getId());
        assertEquals(studentSaved, result);
    }

    @Test
    void findByIdTest() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Juan");

        StudentDTO found = new StudentDTO();

        // Act
        studentDAO.save(studentDTO);
        found = studentDAO.findById(studentDTO.getId());

        // Assert
        assertEquals(studentDTO.getStudentName(), found.getStudentName());
    }

    @Test
    void findByIdSadTest() {
        // Arrange
        Long id = -10L;

        // Act & Assert
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(id));
    }

    @Test
    void deleteTest() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Juan");

        // Act
        boolean result = studentDAO.delete(studentDTO.getId());

        // Assert
        assertFalse(result);
    }

    @Test
    void deleteSadTest() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Juan");
        studentDAO.save(studentDTO);
        studentDAO.delete(studentDTO.getId());

        // Act & Assert
        assertThrows(StudentNotFoundException.class,
                () -> {studentDAO.findById(studentDTO.getId());});
    }

    @Test
    void existTest() {
        // Arrange
        StudentDTO studentToSave = new StudentDTO();
        studentToSave.setStudentName("Juan");
        studentDAO.save(studentToSave);

        // Act
        boolean result = studentDAO.exists(studentToSave);

        // Assert
        assertTrue(result);
    }

    @Test
    void existSadTest() {
        // Arrange
        StudentDTO studentToSave = new StudentDTO();
        studentToSave.setStudentName("Juan");

        // Act
        boolean result = studentDAO.exists(studentToSave);

        // Assert
        assertFalse(result);
    }

}
