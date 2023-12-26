package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
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
class StudentServiceTest {

    @Mock
    StudentDAO dao;

    @Mock
    StudentRepository repo;

    @InjectMocks
    StudentService service;

    static StudentDTO testSubject;

    @BeforeAll
    static void initialize(){
        testSubject = new StudentDTO(
                1L,
                "Juan",
                null,
                null,
                new ArrayList<>(){{
                    add(new SubjectDTO("Matemática", 9.0));
                    add(new SubjectDTO("Física", 7.0));
                    add(new SubjectDTO("Química", 6.0));
                }}
        );
    }

    @Test
    @DisplayName("Create new student")
    void create() {
        doNothing().when(dao).save(testSubject);
        service.create(testSubject);

        verify(dao, atLeast(1)).save(testSubject);
    }
    @Test
    @DisplayName("Create null student")
    void createNull() {
        doNothing().when(dao).save(null);
        service.create(null);

        verify(dao, atLeast(1)).save(null);
    }

    @Test
    @DisplayName("Read valid student id")
    void read() {
        when(dao.findById(1L)).thenReturn(testSubject);

        service.read(1L);

        verify(dao, atLeastOnce()).findById(1L);
    }
    @Test
    @DisplayName("Read not existent student id")
    void readNotExistent() {
        when(dao.findById(1L)).thenThrow(StudentNotFoundException.class);
        assertThrows(StudentNotFoundException.class, () -> service.read(1L));
    }

    @Test
    @DisplayName("Update non-existent student")
    void update() {
        service.update(testSubject);
        verify(dao).save(testSubject);
    }

    @Test
    @DisplayName("Update null student")
    void updateNull() {
        service.update(null);
        verify(dao).save(null);
    }

    @Test
    @DisplayName("Delete non-existent student")
    void delete() {
        service.delete(1L);
        verify(dao).delete(1L);
    }

    @Test
    @DisplayName("Delete null student")
    void deleteNull() {
        service.delete(null);
        verify(dao).delete(null);
    }

    @Test
    void getAll() {
        when(repo.findAll()).thenReturn(new HashSet<>());
        Set<StudentDTO> expected = new HashSet<>();
        Set<StudentDTO> result = service.getAll();

        assertEquals(expected, result);
    }
}