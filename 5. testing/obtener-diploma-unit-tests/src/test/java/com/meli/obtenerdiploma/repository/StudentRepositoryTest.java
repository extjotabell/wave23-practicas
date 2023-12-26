package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class StudentRepositoryTest {

    StudentRepository repository = new StudentRepository();

    @Test
    @DisplayName("Get all students successfully")
    void findAllOk() {
        Set<StudentDTO> expectedResult = getStudentSet();

        Set<StudentDTO> result = repository.findAll();

        assertNotNull(result);
        assertEquals(expectedResult, result);
        assertEquals(expectedResult.size(), result.size());
    }

    private Set<StudentDTO> getStudentSet() {
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