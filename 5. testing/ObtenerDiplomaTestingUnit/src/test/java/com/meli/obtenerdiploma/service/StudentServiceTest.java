package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;
    @Mock

    IStudentRepository studentRepository;

    @InjectMocks
    StudentService service;

    @Test
    void createStudentTest(){
        //Arrange
        StudentDTO dto = new StudentDTO();
        dto.setId(-1L); // Doesn't exist a user with the id equals to -1
        //Act
        service.create(dto);
        //Assert
        Mockito.verify(studentDAO).save(dto);
    }

    @Test
    void readStudentTest(){
        //Arrange
        StudentDTO dto = new StudentDTO(56L, "Felipe", null,null,null);
        Mockito.when(service.read(dto.getId())).thenReturn(dto);
        //Act
        StudentDTO result = service.read(dto.getId());
        //Assert
        Assertions.assertEquals(result, dto);
    }

    @Test
    void updateStudentTest(){
        //Arrange
        StudentDTO dto = new StudentDTO();
        dto.setId(-1L); // Doesn't exist a user with the id equals to -1
        //Act
        service.update(dto);
        //Assert
        Mockito.verify(studentDAO).save(dto);
    }
    @Test
    void deleteStudentTest(){
        //Arrange
        Long id = 5L;
        //Act
        service.delete(id);
        //Assert
        Mockito.verify(studentDAO).delete(5L);
    }

    @Test
    void getAllStudentsTest(){
        //Arrange,
        Set<StudentDTO> expected = new HashSet<>();
        Mockito.when(service.getAll()).thenReturn(expected);
        //Act
        Set<StudentDTO> studentsResult = service.getAll();
        //Assert
        Mockito.verify(studentRepository).findAll();
        Assertions.assertEquals(studentsResult, expected);
    }

}
