package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Analizar score with average above 9.")
    void testAnalyzeScoresShouldReturnCongratulations( ){
        //Arrange
        StudentDTO studentDTO = new StudentDTO();
        List<SubjectDTO> subjects = List.of(new SubjectDTO("Materia 1", 9.5), new SubjectDTO("Materia 2", 9.5));
        studentDTO.setId(1L);
        studentDTO.setStudentName("Estudiante uno");
        studentDTO.setSubjects(subjects);

        StudentDTO expectedStudentDTO = new StudentDTO(1L, "Estudiante uno",
                "El alumno Estudiante uno ha obtenido un promedio de " + new DecimalFormat("#.##").format(9.5)
                        + ". Felicitaciones!",
                9.5, subjects);

        when(studentDAO.findById(anyLong())).thenReturn(studentDTO);

        //Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        //Assert
        assertNotNull(result.getAverageScore());
        assertEquals(expectedStudentDTO.getAverageScore(), result.getAverageScore());
        assertEquals(expectedStudentDTO.getMessage(), result.getMessage());

    }

    @Test
    @DisplayName("Analizar score with average below 9.")
    void testAnalyzeScoresShouldReturnYouCanImprove ( ){
        //Arrange
        StudentDTO studentDTO = new StudentDTO();
        List<SubjectDTO> subjects = List.of(new SubjectDTO("Materia 1", 5.5), new SubjectDTO("Materia 2", 5.5));
        studentDTO.setId(1L);
        studentDTO.setStudentName("Estudiante uno");
        studentDTO.setSubjects(subjects);

        StudentDTO expectedStudentDTO = new StudentDTO(1L, "Estudiante uno",
                "El alumno Estudiante uno ha obtenido un promedio de " + new DecimalFormat("#.##").format(5.5)
                        + ". Puedes mejorar.",
                5.5, subjects);

        when(studentDAO.findById(anyLong())).thenReturn(studentDTO);

        //Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        //Assert
        assertNotNull(result.getAverageScore());
        assertEquals(expectedStudentDTO.getAverageScore(), result.getAverageScore());
        assertEquals(expectedStudentDTO.getMessage(), result.getMessage());

    }

    @Test
    @DisplayName("Analizar score with empty subjects list.")
    void testAnalyzeScoreswithotSubjectsShouldThrowException( ){
        //Arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Estudiante uno");

        when(studentDAO.findById(anyLong())).thenReturn(studentDTO);

        //Act - Assert
        assertThrows(NullPointerException.class, ()-> obtenerDiplomaService.analyzeScores(1L));
    }

}
