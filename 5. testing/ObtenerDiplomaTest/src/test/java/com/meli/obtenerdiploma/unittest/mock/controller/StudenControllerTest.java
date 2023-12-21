package com.meli.obtenerdiploma.unittest.mock.controller;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
class StudenControllerTest {
    @Mock
    private IStudentService studentService;
    @InjectMocks
    private StudentController studentController;

    @Test
    @DisplayName("StudentController - listStudents: check not empty and not null")
    void listStudentsNotEmptyNotNullTest() {
        // Arrange
        int unexpected = 0;
        // Act
        Mockito.when(studentService.getAll()).thenReturn(Set.of(dummyStudent()));
        Set<StudentDTO> actual = studentController.listStudents();
        // Assert
        Assertions.assertNotNull(actual);
        Assertions.assertNotEquals(unexpected, actual.size());
    }

    private StudentDTO dummyStudent(){
        return new StudentDTO(1L,
                "Juan",
                null,
                null,
                List.of(
                        new SubjectDTO("Matemática",9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)
                ));
    }
}
