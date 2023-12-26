package com.meli.obtenerdiploma.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.atLeastOnce;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    StudentDAO dao;

    @Mock
    StudentRepository repository;

    @InjectMocks
    StudentService service;

    StudentDTO studentDTO;

    @BeforeEach
    void initialize() {
        studentDTO = new StudentDTO(
                1L,
                "Juan",
                null,
                null,
                new ArrayList<>() {{
                    add(new SubjectDTO("Matemática", 9.0));
                    add(new SubjectDTO("Física", 7.0));
                    add(new SubjectDTO("Química", 6.0));
                }}
        );
    }

    @Test
    @DisplayName("Test create new student successfully")
    void createOk() {
        service.create(studentDTO);
        verify(dao, atLeastOnce()).save(studentDTO);
    }

    @Test
    @DisplayName("Test create null student")
    void createNullStudent() {
        service.create(null);
        verify(dao, atLeastOnce()).save(null);
    }

    @Test
    @DisplayName("Test read valid student id")
    void readOk() {
        Long param = 1L;
        StudentDTO expectedResult = studentDTO;

        when(dao.findById(1L)).thenReturn(studentDTO);
        StudentDTO result = service.read(param);

        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Test read non-existent student id")
    void readNonExistentId() {
        Long param = 99L;

        when(dao.findById(param)).thenThrow(new StudentNotFoundException(param));
        assertThrows(StudentNotFoundException.class,
                () -> service.read(param)
        );
    }

    @Test
    @DisplayName("Test update student successfully")
    void updateOk() {
        StudentDTO param = studentDTO;

        service.update(param);
        verify(dao, atLeastOnce()).save(studentDTO);
    }

    @Test
    @DisplayName("Test delete student successfully")
    void deleteOk() {
        Long param = 1L;

        service.delete(param);
        verify(dao, atLeastOnce()).delete(param);
    }


    @Test
    @DisplayName("Test delete non-existent student id")
    void deleteNonExistentId() {
        Long param = 99L;
        boolean daoReturn = false;

        when(dao.delete(param)).thenReturn(daoReturn);
        service.delete(param);
        verify(dao, atLeastOnce()).delete(param);
    }

    @Test
    @DisplayName("Test getAll successfully")
    void getAllOk() {
        Set<StudentDTO> expectedResult = getAllStudents();

        when(repository.findAll()).thenReturn(expectedResult);
        Set<StudentDTO> result = service.getAll();

        assertEquals(expectedResult, result);
    }

    private Set<StudentDTO> getAllStudents() {
        Set<StudentDTO> loadedData = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("classpath:users.json");
            loadedData = objectMapper.readValue(file, new TypeReference<Set<StudentDTO>>(){});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }

        return loadedData;
    }
}