package com.meli.obtenerdiploma.unittest.mock.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @Mock
    private IStudentDAO studentDAO;
    @Mock
    private IStudentRepository studentRepository;
    @InjectMocks
    private StudentService studentService;

    @Test
    @DisplayName("StudentService - create: Verifica que el método haya sido llamado")
    void createIsCalledTest(){
        //Arrange
        StudentDTO param = dummyStudent();
        //Act
        studentService.create(param);
        //Assert / Verify
        Mockito.verify(studentDAO).save(param);

    }

    private StudentDTO dummyStudent(){
        return new StudentDTO(1L,
                "Juan",
                null,
                null,
                List.of(
                        new SubjectDTO("Matemática",9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)
                ));
    }
}
