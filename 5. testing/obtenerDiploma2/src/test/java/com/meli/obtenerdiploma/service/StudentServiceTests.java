package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class StudentServiceTests {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    @DisplayName("Find a student OK")
    void findStudentOK() {
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
        Mockito.when(studentDAO.findById(student.getId())).thenReturn(student);
        StudentDTO studentFound = studentService.read(student.getId());

        // Assert
        Assertions.assertEquals(student, studentFound);
    }

    @Test
    @DisplayName("Find a student with a non existing ID")
    void findStudentWithNonExistingID() {
        // Act and Assert
        Mockito.when(studentDAO.findById(1L)).thenThrow(new StudentNotFoundException(1L));
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentService.read(1L));
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
        studentService.create(student);

        // Assert
        Mockito.verify(studentDAO, Mockito.times(1)).save(student);
    }

    @Test
    @DisplayName("Update a student OK")
    void updateStudentOK() {
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
        studentService.update(student);

        // Assert
        Mockito.verify(studentDAO, Mockito.times(1)).save(student);
    }

    @Test
    @DisplayName("Delete a student OK")
    void deleteStudentOK() {
        // Act
        studentService.delete(1L);

        // Assert
        Mockito.verify(studentDAO, Mockito.times(1)).delete(1L);
    }

    @Test
    @DisplayName("Find all students OK")
    void findAllStudentsOK() {
        // Arrange
        Set<StudentDTO> students = new HashSet<>(List.of(
            new StudentDTO(
                1L,
                "John Doe",
                "Test message",
                5.0,
                new ArrayList<>(List.of(
                    new SubjectDTO("Math", 10.0),
                    new SubjectDTO("History", 9.0),
                    new SubjectDTO("Geography", 8.0)
                ))
            ),
            new StudentDTO(
                2L,
                "Jane Doe",
                "Test message",
                5.0,
                new ArrayList<>(List.of(
                    new SubjectDTO("Math", 10.0),
                    new SubjectDTO("History", 9.0),
                    new SubjectDTO("Geography", 8.0)
                ))
            )
        ));

        // Act and Assert
        Mockito.when(studentRepository.findAll()).thenReturn(students);
        Assertions.assertEquals(students.size(), studentService.getAll().size());
    }
}
