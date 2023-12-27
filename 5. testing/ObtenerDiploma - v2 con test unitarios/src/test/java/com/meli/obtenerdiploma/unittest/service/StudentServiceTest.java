package com.meli.obtenerdiploma.unittest.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    public void createTest() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Marcos");

        // Act
        studentService.create(studentDTO);

        // Assert
        verify(studentDAO, times(1)).save(studentDTO);
    }

    @Test
    void readTest() {
        // Arrange
        StudentDTO expected = new StudentDTO(100L, "Marcos", null, null, null);
        when(studentDAO.findById(expected.getId())).thenReturn(expected);

        // Act
        StudentDTO actual = studentService.read(expected.getId());

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void updateStudentTest(){
        //Arrange
        StudentDTO dto = new StudentDTO();
        dto.setId(-1L); // Doesn't exist a user with the id equals to -1
        //Act
        studentService.update(dto);
        //Assert
        verify(studentDAO, times(1)).save(dto);
    }

    @Test
    void deleteTest() {
        // Arrange
        Long id = 5L;

        // Act
        studentService.delete(id);

        // Assert
        verify(studentDAO, times(1)).delete(id);
    }

    @Test
    void getAllTest() {
        // Arrange
        Set<StudentDTO> expected = new HashSet<>();
        when(studentRepository.findAll()).thenReturn(expected);

        // Act
        Set<StudentDTO> actual = studentService.getAll();

        // Assert
        assertEquals(expected, actual);
    }

}
