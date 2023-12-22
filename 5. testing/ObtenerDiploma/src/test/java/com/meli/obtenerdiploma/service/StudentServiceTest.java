package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void create_shouldCallSaveMethodOfStudentDAO() {
        StudentDTO student = new StudentDTO();
        studentService.create(student);
        verify(studentDAO, times(1)).save(student);
    }

    @Test
    void read_shouldReturnStudentDTO_whenStudentExists() {
        StudentDTO student = new StudentDTO();
        when(studentDAO.findById(1L)).thenReturn(student);
        StudentDTO result = studentService.read(1L);
        assertEquals(student, result);
    }

    @Test
    void update_shouldCallSaveMethodOfStudentDAO() {
        StudentDTO student = new StudentDTO();
        studentService.update(student);
        verify(studentDAO, times(1)).save(student);
    }

    @Test
    void delete_shouldCallDeleteMethodOfStudentDAO() {
        studentService.delete(1L);
        verify(studentDAO, times(1)).delete(1L);
    }

    @Test
    void getAll_shouldReturnAllStudents() {
        Set<StudentDTO> students = new HashSet<>();
        when(studentRepository.findAll()).thenReturn(students);
        Set<StudentDTO> result = studentService.getAll();
        assertEquals(students, result);
    }
}
