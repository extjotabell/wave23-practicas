package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;


public class StudentDAOTests {

    IStudentDAO studentDAO;

    @BeforeEach
    @AfterEach
    private void setUp() {
        TestUtilsGenerator.emptyUsersFile();
        this.studentDAO = new StudentDAO();
    }

    @Test
    public void findNonExistentStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act & assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(stu.getId()));
    }

    @Test
    public void deleteExistentStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        studentDAO.save(stu);

        // act
        studentDAO.delete(stu.getId());

        // assert
        Assertions.assertFalse(studentDAO.exists(stu));
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(stu.getId()));
    }

    @Test
    public void deleteNonExistentStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        studentDAO.delete(stu.getId());

        // assert
        Assertions.assertFalse(studentDAO.exists(stu));
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(stu.getId()));
    }


}
