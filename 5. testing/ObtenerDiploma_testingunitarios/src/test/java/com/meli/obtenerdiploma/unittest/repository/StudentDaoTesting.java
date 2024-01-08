package com.meli.obtenerdiploma.unittest.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDaoTesting {

    public StudentDTO student, nonExistentStudent;

    public StudentDAO studentDAO = new StudentDAO();

    @BeforeEach
    void setUp(){
        student = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar", 7.33, List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        )
        );

        nonExistentStudent = new StudentDTO(999L, "Juan", "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar", 7.33, List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        )
        );
    }

    @Test
    @DisplayName("Test Exists - OK")
    void testExists_OK(){
        Boolean actual = studentDAO.exists(student);
        assertTrue(actual);
    }

    @Test
    @DisplayName("Test Exists - Does Not Exists")
    void testExists_ThrowsStudentNotFoundException(){
        Boolean actual = studentDAO.exists(nonExistentStudent);

        assertFalse(actual);
    }

    @Test
    @DisplayName("Test FindById - OK")
    void testFindById_OK(){
        StudentDTO actual = studentDAO.findById(student.getId());
        assertEquals(student.getStudentName(), actual.getStudentName());
    }

    @Test
    @DisplayName("TestFindById - StudentNotFoundException")
    void testFindById_ThrowsStudentNotFoundException(){
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(nonExistentStudent.getId()));
    }

    @Test
    @DisplayName("Save Student - OK")
    void testSave_OK(){
        StudentDTO studentDTO = new StudentDTO(5L, "Juan", "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar", 7.33, List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        )
        );

        studentDAO.save(studentDTO);
        assertEquals(studentDTO.getStudentName(), studentDAO.findById(studentDTO.getId()).getStudentName());
        assertTrue(studentDAO.exists(studentDTO));
    }

}
