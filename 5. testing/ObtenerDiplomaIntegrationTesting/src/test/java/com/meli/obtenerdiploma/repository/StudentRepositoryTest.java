package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.*;

import java.util.Set;

public class StudentRepositoryTest {
    IStudentRepository studentRepository;
    IStudentDAO studentDAO;

    @BeforeEach
    @AfterEach
    private void setUp() {
        TestUtilsGenerator.emptyUsersFile();

        this.studentDAO = new StudentDAO();
        this.studentRepository = new StudentRepository();
    }

    @Test
    @DisplayName("StudentRepository - findAll: Verifica que se encuentren todos los estudiantes cargados")
    public void findAllExistentStudents() {
        // Arrange
        Set<StudentDTO> students = TestUtilsGenerator.getStudentSet();
        students.forEach((stu) -> studentDAO.save(stu));
        // Act
        Set<StudentDTO> foundSet = studentRepository.findAll();
        // Assert
        Assertions.assertTrue(CollectionUtils.isEqualCollection(students, foundSet));
    }

}
