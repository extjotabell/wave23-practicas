package com.meli.obtenerdiploma.unitest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentDAOTest {

    @Autowired
    private StudentDAO studentDAO;


    @Test
    void saveStudentTest() {
        //Arrange
        StudentDTO expected =
                new StudentDTO(1L, "", "mensaje", 9.0,
                        List.of(new SubjectDTO("Matematica", 6.0)));

        //Act
        studentDAO.save(expected);
        StudentDTO act = studentDAO.findById(1L);

        //Assert
        Assertions.assertEquals(expected, act);
    }

    @Test
    void deleteStudentTestOK() {
        //Arrange
        StudentDTO expected =
                new StudentDTO(1L, "", "mensaje", 9.0,
                        List.of(new SubjectDTO("Matematica", 6.0)));

        //Act
        studentDAO.save(expected);
        boolean act = studentDAO.delete(1L);

        //Assert
        Assertions.assertTrue(act);
    }

    @Test
    void deleteStudentTestNoOK() {

        //Arrange
        Long idToRemove = 0L;

        //Act & Assert
        Assertions.assertFalse(studentDAO.delete(idToRemove));
    }

    @Test
    void findStudentTestOK() {
        //Arrange
        Long idToFind = 1L;
        StudentDTO expected =
                new StudentDTO(idToFind, "Pablo", "Mensaje de pablo", 9.0,
                        List.of(new SubjectDTO("Matematica", 6.0)));

        //Act
        studentDAO.save(expected);
        StudentDTO act = studentDAO.findById(idToFind);

        //Assert
        Assertions.assertEquals(expected, act);
    }
}
