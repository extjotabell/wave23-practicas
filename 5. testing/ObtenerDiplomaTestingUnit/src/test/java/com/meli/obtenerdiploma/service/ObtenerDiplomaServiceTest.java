package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO repository;

    @InjectMocks
    private ObtenerDiplomaService service;

    @Test
    void analyzeScoresTestCaseHappyWithHonors() {
        //Arrange
        double score1 = 8;
        double score2 = 10;
        double promedio = (score2+score1)/2;
        StudentDTO studentDTO = new StudentDTO(56L, "Felipe", null, promedio, List.of(new SubjectDTO("Matematica", score1),
                                                                              new SubjectDTO("Lengua", score2)));
        studentDTO.setMessage("El alumno Felipe ha obtenido un promedio de 9.00. Felicitaciones!");
        Mockito.when(repository.findById(studentDTO.getId())).thenReturn(studentDTO);
        //act
        StudentDTO result = service.analyzeScores(56L);
        //assert
        Assertions.assertEquals(result,studentDTO);
    }

    @Test
    void analyzeScoresTestCaseHappy() {
        //Arrange
        double score1 = 7;
        double score2 = 6;
        double promedio = (score2+score1)/2;
        StudentDTO studentDTO = new StudentDTO(56L, "Felipe", null, promedio, List.of(new SubjectDTO("Matematica", score1),
                                                                                      new SubjectDTO("Lengua", score2)));
        studentDTO.setMessage("El alumno Felipe ha obtenido un promedio de 9.00. Puedes mejorar.");
        Mockito.when(repository.findById(studentDTO.getId())).thenReturn(studentDTO);
        //act
        StudentDTO result = service.analyzeScores(studentDTO.getId());
        //assert
        Assertions.assertEquals(result,studentDTO);
    }
    @Test
    void analyzeScoresTestCaseSad() {
        //Arrange
        double score1 = 8;
        double score2 = 10;
        double promedio = (8+10)/2;
        StudentDTO studentDTO = new StudentDTO(-1L, "Felipe", null, promedio, List.of(new SubjectDTO("Matematica", score1),
                                                                                      new SubjectDTO("Lengua", score2)));
        //assert
        Assertions.assertThrows(NullPointerException.class,()-> service.analyzeScores(studentDTO.getId()) );
    }
    @Test
    void analyzeScoresTestCaseInvalidFields() {
        //Arrange
        StudentDTO studentDTO = new StudentDTO(10L, "Felipe", null, null, new ArrayList<>());
        Mockito.when(repository.findById(studentDTO.getId())).thenReturn(studentDTO);
        //act & assert
        Assertions.assertEquals(Double.NaN,service.analyzeScores(studentDTO.getId()).getAverageScore());
        //Assertions.assertThrows(ArithmeticException.class,()-> service.analyzeScores(studentDTO.getId()) );
    }
}
