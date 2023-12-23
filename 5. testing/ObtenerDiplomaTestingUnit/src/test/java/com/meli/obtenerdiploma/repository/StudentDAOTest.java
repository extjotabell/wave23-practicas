package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentDAOTest {

    @Autowired
    StudentDAO repository;


    @Test
    @DisplayName("Finding a student by id - happy case")
    void findByIdHappyCase(){
        //Arrange
        StudentDTO studentToSave = new StudentDTO();
        studentToSave.setStudentName("Felipe");

        repository.save(studentToSave);
        //Act
        StudentDTO result = repository.findById(studentToSave.getId());
        //Assert
        Assertions.assertEquals(result,studentToSave);
    }

    @Test
    @DisplayName("Finding a student by id - sad case")
    void findByIdSadCase(){
        //Arrange
        Long id = -1L; //Doesn't exist a student with a negative id
        //Assert & Act
        Assertions.assertThrows(StudentNotFoundException.class,()-> repository.findById(id));
    }

    @Test
    @DisplayName("Saving a student - happy case")
    void saveStudentHappyTest(){
        //Arrange
        StudentDTO studentToSave = new StudentDTO();
        studentToSave.setStudentName("Felipe");
        //Act
        repository.save(studentToSave);
        //Assert
        StudentDTO result = repository.findById(studentToSave.getId());
        Assertions.assertEquals(result,studentToSave);
    }

    @Test
    @DisplayName("Saving a student - Already exist case")
    void saveStudentAlreadyExistTest(){
        //Arrange
        StudentDTO studentToSave = new StudentDTO();
        studentToSave.setStudentName("Felipe");
        repository.save(studentToSave);
        StudentDTO studentSaved = repository.findById(studentToSave.getId());
        //Act
        repository.save(studentSaved);
        //Assert
        StudentDTO result = repository.findById(studentSaved.getId());
        Assertions.assertEquals(result,studentToSave);
    }

    @Test
    @DisplayName("Exists student - happy case")
    void existUserHappyTest(){
        //Arrange
        StudentDTO studentToSave = new StudentDTO();
        studentToSave.setStudentName("Felipe");
        repository.save(studentToSave);

        //Act
        boolean result = repository.exists(studentToSave);
        //Assert
        Assertions.assertTrue(result, "El student deberia existir");
    }

    @Test
    @DisplayName("Exists student - Sad case")
    void existUserSadTest(){
        //Arrange
        StudentDTO studentToSave = new StudentDTO();
        studentToSave.setStudentName("Pepe");
        //Act
        boolean result = repository.exists(studentToSave);
        //Assert
        Assertions.assertFalse(result, "El student no deberia existir");
    }

    @Test
    @DisplayName("Delet student - Happy case")
    void deleteStudentHappyTest(){
        //Arrange
        StudentDTO studentToSave = new StudentDTO();
        studentToSave.setStudentName("Pepe");
        repository.save(studentToSave);
        //Act
        boolean result = repository.delete(studentToSave.getId());
        //Assert
        Assertions.assertTrue(result, "El student deberia ser eliminado");
    }

    @Test
    @DisplayName("Delet student - Sad case")
    void deleteStudentSadTest(){
        //Arrange
        StudentDTO studentToSave = new StudentDTO();
        studentToSave.setStudentName("Pepe");
        //Act
        boolean result = repository.delete(studentToSave.getId());
        //Assert
        Assertions.assertFalse(result, "El student no deberia ser eliminado ser eliminado");
    }

    @Test
    @DisplayName("Save user exception because .json don't exist")
    void saveUserException1(){
        //Arrange
        StudentDTO studentToSave = new StudentDTO();
        repository.setUri("noexiste.json");
        studentToSave.setStudentName("Felipe");
        //Act
        repository.save(studentToSave);
        //Assert
        StudentDTO result = repository.findById(studentToSave.getId());
        Assertions.assertEquals(result,studentToSave);
        repository.setUri(repository.getURI());
    }
    @Test
    @DisplayName("Save user exception because json format incorrect")
    void saveUserException2(){
        //Arrange
        StudentDTO studentToSave = new StudentDTO();
        repository.setUri("usersBadFormat.json");
        studentToSave.setStudentName("Felipe");
        //Act
        repository.save(studentToSave);
        //Assert
        StudentDTO result = repository.findById(studentToSave.getId());
        Assertions.assertEquals(result,studentToSave);
        repository.setUri(repository.getURI());
    }
}
