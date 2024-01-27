package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentDAOTest {

    private StudentDAO studentDAO;

    @BeforeEach
    void setUp() {
        studentDAO = new StudentDAO();
    }

    @Test
    void shouldSaveStudentWhenDataIsValid() {
        StudentDTO student = new StudentDTO(36L, "John Doe", "Hello", 90.0, new ArrayList<>());
        studentDAO.save(student);
        assertTrue(studentDAO.exists(student));
    }

    @Test
    void shouldThrowExceptionWhenSavingNullStudent() {
        assertThrows(NullPointerException.class, () -> studentDAO.save(null));
    }

    @Test
    void shouldFindStudentByIdWhenExists() {
        StudentDTO student = studentDAO.findById(1L);
        assertNotNull(student);
    }

    @Test
    void shouldThrowExceptionWhenFindingNonExistingStudentById() {
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(999L));
    }

    @Test
    void shouldUpdateStudentDataWhenExists() {
        StudentDTO student = studentDAO.findById(1L);
        student.setMessage("Updated message");
        student.setAverageScore(95.0);
        studentDAO.save(student);
        StudentDTO updatedStudent = studentDAO.findById(1L);
        assertEquals("Updated message", updatedStudent.getMessage());
        assertEquals(95.0, updatedStudent.getAverageScore(), 0.01);
    }

    @Test
    void shouldListAllStudentsWhenExists() {
        assertTrue(studentDAO.exists(studentDAO.findById(1L)));
        assertTrue(studentDAO.exists(studentDAO.findById(2L)));
    }
}