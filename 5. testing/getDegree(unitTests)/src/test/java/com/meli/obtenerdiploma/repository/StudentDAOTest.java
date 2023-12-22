package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class StudentDAOTest {

    @Autowired
    private IStudentDAO studentDAO;
    @Test
    @DisplayName("Add a new student")
    void saveStudentDAOTest() {
        //Arrange
        StudentDTO student = new StudentDTO();
        student.setStudentName("Raul");

        //Act
        studentDAO.save(student);

        //Assert
        StudentDTO savedStudent = studentDAO.findById(student.getId());
        assertEquals(student.getStudentName(), savedStudent.getStudentName());
    }

    @Test
    void findStudentByIdTest() {
        //Arrange
        StudentDTO student = new StudentDTO();
        student.setStudentName("Juan");
        studentDAO.save(student);

        //Act
        StudentDTO foundStudent = studentDAO.findById(student.getId());

        //Assert
        assertEquals(student.getStudentName(), foundStudent.getStudentName());
    }

    @Test
    void updateStudentTest() {
        //Arrange
        StudentDTO student = new StudentDTO();
        student.setStudentName("Juan");
        studentDAO.save(student);
        student.setStudentName("Pedro");

        //Act
        studentDAO.save(student);

        //Assert
        StudentDTO updatedStudent = studentDAO.findById(student.getId());
        assertEquals("Pedro", updatedStudent.getStudentName());
    }

    @Test
    void deleteStudentTest() {
        //Arrange
        StudentDTO student = new StudentDTO();
        student.setStudentName("Juan");
        studentDAO.save(student);

        //Act
        studentDAO.delete(student.getId());

        //Assert
        assertNull(studentDAO.findById(student.getId()));
    }

    @Test
    void findAllStudentsTest() {
        //Arrange
        StudentDTO student1 = new StudentDTO();
        student1.setStudentName("Juan");
        studentDAO.save(student1);

        StudentDTO student2 = new StudentDTO();
        student2.setStudentName("Pedro");
        studentDAO.save(student2);

        //Act
        boolean existsStudent1 = studentDAO.exists(student1);
        boolean existsStudent2 = studentDAO.exists(student2);

        //Assert
        assertTrue(existsStudent1);
        assertTrue(existsStudent2);
    }
}
