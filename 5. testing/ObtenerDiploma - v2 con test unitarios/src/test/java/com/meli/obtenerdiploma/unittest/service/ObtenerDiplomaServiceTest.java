package com.meli.obtenerdiploma.unittest.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void analyzeScoresTest() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Marcos");
        studentDTO.setSubjects(List.of(
                new SubjectDTO("Matemática", 8.0),
                new SubjectDTO("Química", 9.0),
                new SubjectDTO("Física", 10.0)
        ));
        StudentDTO obtained = new StudentDTO();

        // Act
        when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);
        obtained = obtenerDiplomaService.analyzeScores(studentDTO.getId());

        // Assert
        assertEquals(9, obtained.getAverageScore());
        assertEquals("El alumno Marcos ha obtenido un promedio de 9. Puedes mejorar.", obtained.getMessage());
    }

    @Test
    void analyzeScoresTestSad() {
        //Arrange
        StudentDTO studentDTO = new StudentDTO(100L, "Marcos", null, null, null);

        // Act & Assert
        assertThrows(NullPointerException.class,()-> obtenerDiplomaService.analyzeScores(studentDTO.getId()) );
    }

    @Test
    void analyzeScoresHonorsTest() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Marcos");
        studentDTO.setSubjects(List.of(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Química", 10.0),
                new SubjectDTO("Física", 10.0)
        ));
        StudentDTO obtained = new StudentDTO();

        // Act
        when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);
        obtained = obtenerDiplomaService.analyzeScores(studentDTO.getId());

        // Assert
        assertEquals(10, obtained.getAverageScore());
        assertEquals("El alumno Marcos ha obtenido un promedio de 10. Felicitaciones!", obtained.getMessage());
    }

    @Test
    void analyzeScoresHonorsSadTest() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Marcos");

        when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);

        // Act & Assert
        assertThrows(NullPointerException.class,()-> obtenerDiplomaService.analyzeScores(studentDTO.getId()) );
    }

}
