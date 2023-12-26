package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    @DisplayName("Save a student.")
    void createStudentShouldSaveWithDAOMethod(){
        //Arrange
        StudentDTO studentDTO = new StudentDTO();

        //Act
        studentService.create(studentDTO);

        //Assert
        verify(studentDAO, times(1)).save(studentDTO);
    }

    @Test
    @DisplayName("Read student by id")
    void readStudentByIdShouldReturnExistingStudent(){
        //Arrange
        StudentDTO studentDTOExpected = new StudentDTO();
        when(studentDAO.findById(anyLong())).thenReturn(studentDTOExpected);

        //Act
        StudentDTO result = studentService.read(1L);

        //Assert
        assertEquals(studentDTOExpected, result);
        verify(studentDAO, times(1)).findById(1L);
    }

    @Test
    @DisplayName("Update a student.")
    void updateStudentShouldUpdateWithDAOMethod(){
        //Arrange
        StudentDTO studentDTO = new StudentDTO();

        //Act
        studentService.update(studentDTO);

        //Assert
        verify(studentDAO, times(1)).save(studentDTO);
    }

    @Test
    @DisplayName("Delete a student.")
    void deleteStudentShouldDeleteWithDAOMethod(){
        //Arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);

        //Act
        studentService.delete(1L);

        //Assert
        verify(studentDAO, times(1)).delete(studentDTO.getId());
    }

    @Test
    @DisplayName("Get list of students.")
    void getAllShouldReturnAList(){
        //Act
        Set<StudentDTO> expectedList = new HashSet<>(List.of(new StudentDTO(), new StudentDTO()));
        when(studentRepository.findAll()).thenReturn(expectedList);
        //Arrange
        Set <StudentDTO> result = studentService.getAll();

        //Assert
        assertEquals(expectedList, result);
    }

}
