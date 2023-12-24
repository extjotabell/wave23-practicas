package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreate() {
        StudentDTO student = new StudentDTO();
        service.create(student);

        when(service.read(4L)).thenReturn(student);

        StudentDTO studentResult = service.read(4L);

        verify(studentDAO, times(1)).save(student);
        assertEquals(student, studentResult);
    }

    @Test
    void testRead() {
        StudentDTO student = new StudentDTO();
        student.setId(4L);
        student.setStudentName("Juan");

        when(service.read(4L)).thenReturn(student);

        StudentDTO studentResult = service.read(4L);

        verify(studentDAO, times(1)).findById(4L);
        assertEquals(student, studentResult);
    }

    @Test
    void testUpdate() {
        StudentDTO student = new StudentDTO();

        service.update(student);

        when(service.read(4L)).thenReturn(student);

        StudentDTO studentResult = service.read(4L);

        verify(studentDAO, times(1)).save(student);
        assertEquals(student, studentResult);
    }

    @Test
    void testDelete() {
        service.delete(4L);
        verify(studentDAO, times(1)).delete(4L);
    }

    @Test
    void testGetAll() {
        Set<StudentDTO> students = Set.of(new StudentDTO(), new StudentDTO(), new StudentDTO());

        when(service.getAll()).thenReturn(students);

        Set<StudentDTO> studentsResult = service.getAll();

        verify(studentRepository, times(1)).findAll();
        assertEquals(students, studentsResult);
    }
}
