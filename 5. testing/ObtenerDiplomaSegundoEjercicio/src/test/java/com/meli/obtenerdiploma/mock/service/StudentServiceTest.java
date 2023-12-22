package com.meli.obtenerdiploma.mock.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    StudentDAO studentDAO;

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    static StudentDTO student;

    @BeforeAll
    static void initialize() {
         student = new StudentDTO(
                1L,
                "Nico",
                null,
                null,
                new ArrayList<>() {{
                    add(new SubjectDTO("Lengua", 8.0));
                    add(new SubjectDTO("Informatica", 7.0));
                    add(new SubjectDTO("Gimnasia", 7.0));
                }}
        );
    }

    @Test
    @DisplayName("Crear estudiante")
    void create() {

        studentService.create(student);

        verify(studentDAO, atLeast(1)).save(student);
    }

    @Test
    @DisplayName("Crear estudiante null")
    void createNull() {

        studentService.create(null);

        verify(studentDAO, atLeast(1)).save(null);
    }

    @Test
    @DisplayName("Buscar estudiante")
    void read() {
        when(studentDAO.findById(1L)).thenReturn(student);

        studentService.read(1L);

        verify(studentDAO, atLeastOnce()).findById(1L);
    }

    @Test
    @DisplayName("Buscar estudiante no existente")
    void readNotExistentStudent() {
        when(studentDAO.findById(anyLong())).thenThrow(new StudentNotFoundException(1L));

        assertThrows(StudentNotFoundException.class, () -> studentService.read(1L));
    }

    @Test
    @DisplayName("Actualizar estudiante")
    void update() {

        assertDoesNotThrow(() -> studentService.update(student));

        verify(studentDAO, times(1)).save(student);
    }

    @Test
    @DisplayName("Eliminar estudiante")
    void delete() {
        assertDoesNotThrow(() -> studentService.delete(1L));

        verify(studentDAO, times(1)).delete(1L);
    }

    @Test
    @DisplayName("Obtener estudiantes")
    void getAll() {
        Set<StudentDTO> students = new HashSet<>();
        students.add(student);

        when(studentRepository.findAll()).thenReturn(students);

        assertEquals(students, studentService.getAll());
    }

}
