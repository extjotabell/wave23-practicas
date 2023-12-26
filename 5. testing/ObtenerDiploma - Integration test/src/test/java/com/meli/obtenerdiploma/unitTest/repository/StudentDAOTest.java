package com.meli.obtenerdiploma.unitTest.repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTest {

    @Test
    @DisplayName("save ok")
    void saveOk() {
        //arrange
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", "Message", 9.23, List.of(
                new SubjectDTO("Matematica", 9.0),
                new SubjectDTO("Quimica", 9.0)
        ));

        //act
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.save(studentDTO);

        //assert
        assertEquals(studentDTO,studentDAO.findById(studentDTO.getId()));
    }

    @Test
    @DisplayName("Delete ok")
    void deleteOk() {
        //arrange
        long id=1L;
        boolean expected = true;
        //act
       StudentDAO studentDAO = new StudentDAO();
       boolean actual = studentDAO.delete(id);

        //assert
        Assertions.assertEquals(expected,actual);
    }
    @Test
    @DisplayName("Delete id not found")
    void deleteBadWay() {
        //arrange
        long id=19999L;
        //act
        StudentDAO studentDAO = new StudentDAO();
        //assert
        Assertions.assertThrows(StudentNotFoundException.class, ()->{studentDAO.delete(id);});
    }
    @Test
    @DisplayName("find by id ok")
    void findByIdOk(){
        //Arrange
        long id = 1L;
        //Act
        StudentDAO studentDAO = new StudentDAO();
        StudentDTO actual = studentDAO.findById(id);
        //Assert
        Assertions.assertNotNull(actual);
    }
    @Test
    @DisplayName("find by id bad")
    void findByIdNotFound(){
        //Arrange
        long id = 100000L;
        //Act
        StudentDAO studentDAO = new StudentDAO();
        //Assert
        assertThrows(StudentNotFoundException.class,()->studentDAO.findById(id));
    }
}