package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class studentDAOTest {
    private StudentDAO studentDAO;

    @BeforeEach
    void setUp(){
        studentDAO = new StudentDAO();
    }

    @Test
    void testSaveNewStudent() {
        StudentDTO newStudent = new StudentDTO();
        newStudent.setId(1L);
        newStudent.setStudentName("New Student");

        studentDAO.save(newStudent);

        StudentDTO savedStudent = studentDAO.findById(1L);
        assertNotNull(savedStudent);
        assertEquals("New Student", savedStudent.getStudentName());
    }

    @Test
    void testUpdateExistingStudent() {
        StudentDTO existingStudent = studentDAO.findById(2L);
        assertNotNull(existingStudent);

        existingStudent.setStudentName("Updated Student");
        studentDAO.save(existingStudent);

        StudentDTO updatedStudent = studentDAO.findById(2L);
        assertEquals("Updated Student", updatedStudent.getStudentName());
    }

    @Test
    void testDeleteExistingStudent() {
        StudentDTO student = studentDAO.findById(2L);
        assertNotNull(student);

        assertTrue(studentDAO.delete(3L));
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(3L));
    }

    @Test
    void testFindByIdNonExistent() {
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(999L));
    }

    @Test
    void testFindByIdWithNullId() {
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(null));
    }

    @Test
    void testDeleteNonExistentStudent() {
        assertFalse(studentDAO.delete(999L));
    }
}
