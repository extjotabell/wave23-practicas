package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Test
    @DisplayName("Get all students successfully")
    void findAll() {
        IStudentRepository repo = new StudentRepository();
        Set<StudentDTO> expectedResult = new HashSet<>(){{
            add(new StudentDTO(
                    1L,
                    "Juan",
                    null,
                    null,
                    new ArrayList<>(){{
                        add(new SubjectDTO("Matemática", 9.0));
                        add(new SubjectDTO("Física", 7.0));
                        add(new SubjectDTO("Química", 6.0));
                    }}
            ));
            add(new StudentDTO(
                    2L,
                    "Pedro",
                    null,
                    null,
                    new ArrayList<>(){{
                        add(new SubjectDTO("Matemática", 10.0));
                        add(new SubjectDTO("Física", 8.0));
                        add(new SubjectDTO("Química", 4.0));
                    }}
            ));
        }};

        Set<StudentDTO> result = repo.findAll();

        assertNotNull(result);
        assertEquals(expectedResult, result);
        assertEquals(expectedResult.size(), result.size());
    }
}