package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Test
    @DisplayName("Get all students successfully")
    void findAll() {
        // Arrange
        // Create an instance of StudentRepository to test
        IStudentRepository repo = new StudentRepository();
        // Create a set of expected students for testing purposes
        Set<StudentDTO> expectedResult = createExpectedStudents();

        // Act
        // Call the findAll method of the repository
        Set<StudentDTO> result = repo.findAll();

        // Assert
        // Check that the result is not null
        // Check that the result is equal to the expected set of students
        // Check that the size of the result is equal to the size of the expected set
        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(expectedResult, result),
                () -> assertEquals(expectedResult.size(), result.size())
        );
    }

    private Set<StudentDTO> createExpectedStudents() {
        // Create a set to hold the expected students
        Set<StudentDTO> students = new HashSet<>();
        // Add students with specific data to the set
        students.add(createStudent(1L, "Juan", createSubjects(9.0, 7.0, 6.0)));
        students.add(createStudent(2L, "Pedro", createSubjects(10.0, 8.0, 4.0)));
        return students;
    }

    /**
     * Creates a student with the given parameters.
     *
     * @param id      The student's ID.
     * @param name    The student's name.
     * @param subjects The subjects and their grades for the student.
     * @return {@link StudentDTO}
     */
    private StudentDTO createStudent(Long id, String name, List<SubjectDTO> subjects) {
        // Create a new instance of StudentDTO with the provided parameters
        return new StudentDTO(id, name, null, null, new ArrayList<>(subjects));
    }

    private List<SubjectDTO> createSubjects(Double... grades) {
        // Create a list to hold the subjects with their grades
        List<SubjectDTO> subjects = new ArrayList<>();
        // Define subject names
        String[] subjectNames = {"Matemática", "Física", "Química"};

        // Loop through grades and subject names, creating SubjectDTO objects and adding them to the list
        for (int i = 0; i < grades.length && i < subjectNames.length; i++) {
            subjects.add(new SubjectDTO(subjectNames[i], grades[i]));
        }
        return subjects;
    }
}
