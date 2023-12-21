package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
    @DisplayName("Buscar un alumno por Id")
    void findByIdTest(){
        //Arrange
        Long studentId = 2L;

        //Act
        StudentDTO studentReturned = studentDAO.findById(studentId);

        //Assert
        assertNotNull(studentReturned);
    }
}
