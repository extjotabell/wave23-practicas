package com.meli.obtenerdiploma.unitest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository repository;

    @InjectMocks
    StudentService service;

    @Test
    void createStudent_SuccessfullyCreatesStudent() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(1L, "John Doe", "message..", 90.0d, List.of(new SubjectDTO("Historia", 9.0)));

        // Act
        service.create(studentDTO);

        verify(studentDAO, times(1)).save(studentDTO);
    }

    @Test
    void readStudent_ReturnsStudentDTO() {
        // Arrange
        Long studentId = 1L;
        StudentDTO expectedStudentDTO = new StudentDTO(studentId, "John Doe", "message..", 90.0d, List.of(new SubjectDTO("Historia", 9.0)));

        when(studentDAO.findById(studentId)).thenReturn(expectedStudentDTO);

        // Act
        StudentDTO actualStudentDTO = service.read(studentId);

        // Assert
        assertEquals(expectedStudentDTO, actualStudentDTO);
    }

    @Test
    void getAllStudents_ReturnsSetOfStudentDTOs() {
        // Arrange
        Set<StudentDTO> expectedStudents = new HashSet<>();
        expectedStudents.add(new StudentDTO(1L, "John Doe", "message..", 90.0d, List.of(new SubjectDTO("Historia", 9.0))));
        expectedStudents.add(new StudentDTO(2L, "John Doe", "message..", 90.0d, List.of(new SubjectDTO("Historia", 9.0))));

        when(repository.findAll()).thenReturn(expectedStudents);

        // Act
        Set<StudentDTO> actualStudents = service.getAll();

        // Assert
        assertEquals(expectedStudents, actualStudents);
    }
}
