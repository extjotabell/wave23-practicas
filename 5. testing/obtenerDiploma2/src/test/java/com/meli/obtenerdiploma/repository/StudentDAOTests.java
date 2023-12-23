package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class StudentDAOTests {

    IStudentDAO studentDAO;

    @BeforeEach
    void setUp() {
        this.studentDAO = new StudentDAO();
    }

    @Test
    @DisplayName("Create a new student OK")
    void createStudentOK() {
        // Arrange
        StudentDTO student = new StudentDTO(
            1L,
            "John Doe",
            "Test message",
            5.0,
            new ArrayList<>(List.of(
                new SubjectDTO("Math", 10.0),
                new SubjectDTO("History", 9.0),
                new SubjectDTO("Geography", 8.0)
            ))
        );

        // Act
        studentDAO.save(student);
        StudentDTO studentFound = studentDAO.findById(student.getId());

        // Assert
        Assertions.assertTrue(studentDAO.exists(student));
        Assertions.assertEquals(student, studentFound);
    }

    @Test
    @DisplayName("Create a new student with an existing ID")
    void createStudentWithExistingID() {
        // Arrange
        StudentDTO student = new StudentDTO(
            1L,
            "John Doe",
            "Test message",
            5.0,
            new ArrayList<>(List.of(
                new SubjectDTO("Math", 10.0),
                new SubjectDTO("History", 9.0),
                new SubjectDTO("Geography", 8.0)
            ))
        );

        // Act
        studentDAO.save(student);
        studentDAO.save(student);

        StudentDTO studentFound = studentDAO.findById(student.getId());

        // Assert
        Assertions.assertTrue(studentDAO.exists(student));
        Assertions.assertEquals(student, studentFound);
    }

    @Test
    @DisplayName("Find a student by ID not found")
    void findStudentByIDNotFound() {
        // Act and Assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(99L));
    }

    @Test
    @DisplayName("Modify a student OK")
    void modifyStudentOK() {
        // Arrange
        StudentDTO student = new StudentDTO(
            1L,
            "John Doe",
            "Test message",
            5.0,
            new ArrayList<>(List.of(
                new SubjectDTO("Math", 10.0),
                new SubjectDTO("History", 9.0),
                new SubjectDTO("Geography", 8.0)
            ))
        );

        // Act
        studentDAO.save(student);

        StudentDTO studentToModify = studentDAO.findById(student.getId());
        studentToModify.setStudentName("Jane Doe");
        studentDAO.save(studentToModify);

        StudentDTO studentModified = studentDAO.findById(student.getId());

        // Assert
        Assertions.assertTrue(studentDAO.exists(studentModified));
        Assertions.assertEquals(studentModified, studentToModify);
    }

    @Test
    @DisplayName("Delete a student OK")
    void deleteStudentOK() {
        // Arrange
        StudentDTO student = new StudentDTO(
            1L,
            "John Doe",
            "Test message",
            5.0,
            new ArrayList<>(List.of(
                new SubjectDTO("Math", 10.0),
                new SubjectDTO("History", 9.0),
                new SubjectDTO("Geography", 8.0)
            ))
        );

        // Act
        studentDAO.save(student);
        studentDAO.delete(student.getId());

        // Assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(1L));
    }
}
