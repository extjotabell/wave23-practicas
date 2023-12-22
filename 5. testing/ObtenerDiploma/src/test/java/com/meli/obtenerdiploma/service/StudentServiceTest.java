package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
    static void initialize() {
        // Set up a test student with ID 1, name "Juan," and subjects with grades
        testSubject = new StudentDTO(
                1L,
                "Juan",
                null,
                null,
                new ArrayList<>(){{
                    add(new SubjectDTO("Math", 9.0));
                    add(new SubjectDTO("Physics", 7.0));
                    add(new SubjectDTO("Chemistry", 6.0));
                }}
        );
    }

    @Test
    @DisplayName("Create new student")
    void create() {
        // Stub the save method of the dao to do nothing
        doNothing().when(dao).save(testSubject);

        // Call the create method of the service
        service.create(testSubject);

        // Verify that the save method of the dao was called at least once with the testSubject
        verify(dao, atLeast(1)).save(testSubject);
    }

    @Test
    @DisplayName("Create null student")
    void createNull() {
        // Stub the save method of the dao to do nothing
        doNothing().when(dao).save(null);

        // Call the create method of the service with a null student
        service.create(null);

        // Verify that the save method of the dao was called at least once with null
        verify(dao, atLeast(1)).save(null);
    }

    @Test
    @DisplayName("Read valid student id")
    void read() {
        // Stub the findById method of the dao to return the testSubject when called with ID 1
        when(dao.findById(1L)).thenReturn(testSubject);

        // Call the read method of the service with ID 1
        service.read(1L);

        // Verify that the findById method of the dao was called at least once with ID 1
        verify(dao, atLeastOnce()).findById(1L);
    }

    @Test
    @DisplayName("Read non-existent student id")
    void readNotExistent() {
        // Stub the findById method of the dao to throw a StudentNotFoundException when called with any ID
        when(dao.findById(anyLong())).thenThrow(new StudentNotFoundException(1L));

        // Assert that calling the read method of the service with ID 1 throws a StudentNotFoundException
        assertThrows(StudentNotFoundException.class, () -> service.read(1L));
    }

    @Test
    @DisplayName("Update existing student")
    void update() {
        // Stub the save method of the dao to do nothing
        doNothing().when(dao).save(testSubject);

        // Assert that calling the update method of the service with the testSubject does not throw an exception
        assertDoesNotThrow(() -> service.update(testSubject));

        // Verify that the save method of the dao was called exactly once with the testSubject
        verify(dao, times(1)).save(testSubject);
    }

    @Test
    @DisplayName("Update non-existent student")
    void updateNonExistent() {
        // Assert that calling the update method of the service with the testSubject does not throw an exception
        assertDoesNotThrow(() -> service.update(testSubject));

        // Verify that the save method of the dao was called exactly once with the testSubject
        verify(dao, times(1)).save(testSubject);
    }

    @Test
    @DisplayName("Delete existing student")
    void delete() {
        // Assert that calling the delete method of the service with ID 1 does not throw an exception
        assertDoesNotThrow(() -> service.delete(1L));

        // Verify that the delete method of the dao was called exactly once with ID 1
        verify(dao, times(1)).delete(1L);
    }

    @Test
    @DisplayName("Delete non-existent student")
    void deleteNonExistent() {
        // Assuming dao.delete returns a boolean indicating whether the deletion was successful
        // Stub the delete method of the dao to return false when called with any Long argument
        when(dao.delete(anyLong())).thenReturn(false);

        // Call the delete method of the service with ID 1
        service.delete(1L);

        // Verify that the delete method of the dao was called exactly once with any Long argument
        verify(dao, times(1)).delete(anyLong());
    }

    @Test
    @DisplayName("Get all students")
    void getAll() {
        // Set up a HashSet with the testSubject
        Set<StudentDTO> students = new HashSet<>();
        students.add(testSubject);

        // Stub the findAll method of the repo to return the HashSet when called
        when(repo.findAll()).thenReturn(students);

        // Assert that calling the getAll method of the service returns the HashSet
        assertEquals(students, service.getAll());
    }
}
