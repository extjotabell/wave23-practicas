package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;
    @InjectMocks
    StudentService studentService;

    @Test
    @DisplayName("Leer un estudiante")
    void readTest(){
        //Arrange
        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO subject1 = new SubjectDTO("Lengua", 6.0);
        subjects.add(subject1);
        StudentDTO student = new StudentDTO(1L, "Juan Perez", "mensaje", 8.0, subjects);

        //Act
        when(studentDAO.findById(1L)).thenReturn(student);
        StudentDTO studentReturned = studentService.read(1L);

        //Assert
        assertEquals(student, studentReturned);
    }
}
