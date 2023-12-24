package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentDAOTest {

    private IStudentDAO studentDAO;

    @BeforeEach
    void setUp() {
        studentDAO = new StudentDAO();
    }

    @Test
    @DisplayName("Test save student valid")
    void saveStudentOKTest(){
        // arrange
        StudentDTO stu = new StudentDTO(24L, "John Doe", "Hello", 90.0, new ArrayList<>());

        // act
        studentDAO.save(stu);

        // assert
        assertTrue(studentDAO.exists(stu));
        assertEquals(24L, stu.getId());
        assertEquals(studentDAO.findById(stu.getId()), stu);

    }

    @Test
    @DisplayName("Test save student invalid")
    void saveStudentNOKTest(){
        // arrange
        StudentDTO stu = new StudentDTO();

        // act
        studentDAO.save(stu);

        // assert
        assertThrows(NullPointerException.class, () -> studentDAO.save(null));
    }

    @Test
    @DisplayName("Test find student id exist")
    void findExistIdTest(){
        /// arrange
        StudentDTO stu = new StudentDTO(1L, "John Doe", "Hello", 90.0, new ArrayList<>());
        studentDAO.save(stu);

        // act
        StudentDTO found = studentDAO.findById(stu.getId());

        // assert
        assertEquals(found, stu);
        assertNotNull(stu);

    }

    @Test
    @DisplayName("Test find id not exist")
    void findNotExistIdTest(){
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(999L));

    }

    @Test
    @DisplayName("Test delete id exist")
    public void deleteExistentStudent() {
        // arrange
        StudentDTO stu = new StudentDTO(1L, "John Doe", "Hello", 90.0, new ArrayList<>());
        studentDAO.save(stu);

        // act
        studentDAO.delete(stu.getId());

        // assert
        assertFalse(studentDAO.exists(stu));
        assertThrows(StudentNotFoundException.class,() -> studentDAO.findById(stu.getId()));
    }

    @Test
    @DisplayName("Test delete not id exist")
    public void deleteNotExistentStudent() {
        // arrange
        StudentDTO stu = new StudentDTO(1L, "John Doe", "Hello", 90.0, new ArrayList<>());

        studentDAO.delete(stu.getId());

        // assert
        assertFalse(studentDAO.exists(stu));
        assertThrows(StudentNotFoundException.class,() -> studentDAO.findById(stu.getId()));
    }

    @Test
    @DisplayName("Test update non existent Student")
    void updateStudentNonExists() {
        // arrange
        StudentDTO stu = new StudentDTO(10L, "John Doe", "Hello", 90.0, new ArrayList<>());
        studentDAO.save(stu);
        StudentDTO student = studentDAO.findById(10L);
        // act
        student.setMessage("Updated message");
        student.setAverageScore(95.0);
        studentDAO.save(student);
        StudentDTO updatedStudent = studentDAO.findById(10L);
        // assert
        assertEquals("Updated message", updatedStudent.getMessage());
        assertEquals(95.0, updatedStudent.getAverageScore(), 0.01);
    }


}
