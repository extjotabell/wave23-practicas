package com.meli.obtenerdiploma.unittest.mock.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.apache.catalina.filters.RequestDumperFilter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {
    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    /*
        Pueden existir muchas más pruebas que estas, esto solo cubre algunos casos base
    */
    @Test
    @DisplayName("Validación analyzeScore servicio ObtenerDiploma: Mensaje no nulo, promedio no nulo, " +
            "promedio correctamente calculado, diploma sin honores.")
    void analyzeScoresTest(){
        //Arrange
        Long paramStudentId = 1L;
        StudentDTO expected = createExpectedForAnalyzeScoreTest();
        //Act
        Mockito.when(studentDAO.findById(paramStudentId)).thenReturn(createDummyForAnalyzeScoreMock());
        StudentDTO actual = obtenerDiplomaService.analyzeScores(paramStudentId);
        //Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Validación analyzeScore servicio ObtenerDiploma, mensaje con honores.")
    void analyzeScoresHonoresTest(){
        //Arrange
        Long paramStudentId = 1L;
        StudentDTO expected = createExpectedForAnalyzeScoreHonoresTest();
        //Act
        Mockito.when(studentDAO.findById(paramStudentId)).thenReturn(createDummyForAnalyzeScoreMockHonores());
        StudentDTO actual = obtenerDiplomaService.analyzeScores(paramStudentId);
        //Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Validación analyzeScore servicio ObtenerDiploma, límite promedio para tener mensaje sin honores.")
    void analyzeScoresLimitAverageTest(){
        //Arrange
        Long paramStudentId = 1L;
        StudentDTO expected = createExpectedForAnalyzeScoreLimitAverageTest();
        //Act
        Mockito.when(studentDAO.findById(paramStudentId)).thenReturn(createDummyForAnalyzeScoreMockLimitAverage());
        StudentDTO actual = obtenerDiplomaService.analyzeScores(paramStudentId);
        //Assert
        Assertions.assertEquals(expected, actual);
    }

    private StudentDTO createDummyForAnalyzeScoreMock(){
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

    private StudentDTO createExpectedForAnalyzeScoreTest() {
        return new StudentDTO(1L,
                "Juan",
                "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.",
                (9.0 + 7.0 + 6.0) / 3,
                List.of(
                        new SubjectDTO("Matemática",9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)
                ));
    }

    private StudentDTO createDummyForAnalyzeScoreMockHonores(){
        return new StudentDTO(1L,
                "Juan",
                null,
                null,
                List.of(
                        new SubjectDTO("Matemática",10.0),
                        new SubjectDTO("Física", 9.0),
                        new SubjectDTO("Química", 9.0)
                ));
    }

    private StudentDTO createExpectedForAnalyzeScoreHonoresTest() {
        return new StudentDTO(1L,
                "Juan",
                "El alumno Juan ha obtenido un promedio de 9.33. Felicitaciones!",
                (10.0 + 9.0 + 9.0) / 3,
                List.of(
                        new SubjectDTO("Matemática",10.0),
                        new SubjectDTO("Física", 9.0),
                        new SubjectDTO("Química", 9.0)
                ));
    }

    private StudentDTO createDummyForAnalyzeScoreMockLimitAverage(){
        return new StudentDTO(1L,
                "Juan",
                null,
                null,
                List.of(
                        new SubjectDTO("Matemática",9.0),
                        new SubjectDTO("Física", 9.0),
                        new SubjectDTO("Química", 9.0)
                ));
    }

    private StudentDTO createExpectedForAnalyzeScoreLimitAverageTest() {
        return new StudentDTO(1L,
                "Juan",
                "El alumno Juan ha obtenido un promedio de 9. Puedes mejorar.",
                (9.0 + 9.0 + 9.0) / 3,
                List.of(
                        new SubjectDTO("Matemática",9.0),
                        new SubjectDTO("Física", 9.0),
                        new SubjectDTO("Química", 9.0)
                ));
    }


}
