package com.meli.obtenerdiploma.unittest.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository repository;

    @InjectMocks
    StudentService service;

    StudentDTO student;
    List<SubjectDTO> subjects;

    @BeforeEach
    void setUp(){
        subjects = List.of(
                new SubjectDTO("Matematica", 8.0),
                new SubjectDTO("Fisica", 8.0)
        );

        student = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de 8.0. Puedes mejorar", 8.0, subjects);
    }

    @Test
    @DisplayName("Test Read - OK")
    void testRead_OK(){
        when(studentDAO.findById(1L)).thenReturn(student);

        StudentDTO expected = service.read(1L);

        assertEquals(expected.getStudentName(), student.getStudentName());
    }

    @Test
    @DisplayName("Test Read - StudentNotFound Exception")
    void testRead_ThrowsStudentNotFoundException(){
        when(studentDAO.findById(anyLong())).thenThrow(StudentNotFoundException.class);

        assertThrows(StudentNotFoundException.class, () -> service.read(999L));
    }

}
