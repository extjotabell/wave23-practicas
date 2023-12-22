package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeastOnce;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTests {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService service;

    @Test
    @DisplayName("ObtenerDiplomaService - analyzeScore: Verificar que la calificación sea correctamente calculada.")
    void averageScoreWellCalculated() {
        // Arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Fernando");
        Mockito.when(studentDAO.findById(stu.getId())).thenReturn(stu);
        // Act
        service.analyzeScores(stu.getId());
        // Assert
        Mockito.verify(studentDAO, Mockito.calls(1)).findById(stu.getId());
        assertEquals(6.0, stu.getAverageScore());
    }

    @Test
    @DisplayName("ObtenerDiplomaService - analyzeScore: Diploma con mensaje de felicitaciones.")
    void averageScoreOver9MessageWellWritten() {
        // Arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Fernando");
        Mockito.when(studentDAO.findById(stu.getId())).thenReturn(stu);
        // Act
        service.analyzeScores(stu.getId());
        // Assert
        Mockito.verify(studentDAO, Mockito.calls(1)).findById(stu.getId());
        assertEquals("El alumno Fernando ha obtenido un promedio de 9.00. Felicitaciones!", stu.getMessage());
    }

    @Test
    @DisplayName("ObtenerDiplomaService - analyzeScore: Diploma con mensaje de 'puedes mejorar'.")
    public void averageScoreBelow9MessageWellWritten() {
        // Arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Fernando");
        when(studentDAO.findById(stu.getId())).thenReturn(stu);
        // Act
        service.analyzeScores(stu.getId());
        // Assert
        verify(studentDAO, atLeastOnce()).findById(stu.getId());
        assertEquals("El alumno Fernando ha obtenido un promedio de 6.00. Puedes mejorar.", stu.getMessage());
    }

    @Test
    @DisplayName("ObtenerDiplomaService - analyzeScore: Verificar que el nombre es correcto.")
    void RequestStudentNameMatchesResponseStudentName() {
        // Arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Fernando");
        when(studentDAO.findById(stu.getId())).thenReturn(stu);
        // Act
        service.analyzeScores(stu.getId());
        // Asser
        verify(studentDAO, atLeastOnce()).findById(stu.getId());
        assertEquals("Fernando", stu.getStudentName());
    }

    @Test
    @DisplayName("ObtenerDiplomaService - analyzeScore: " +
            "Verificar que la lista de materias del request sea la misma a la lista de materias de la respuesta.")
    void RequestStudentSubjectListMatchesResponseSubjectList() {
        // Arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Fernando");
        List<SubjectDTO> initialList = new ArrayList<>();
        stu.getSubjects().forEach(s -> initialList.add(SerializationUtils.clone(s)));
        when(studentDAO.findById(stu.getId())).thenReturn(stu);
        // Act
        service.analyzeScores(stu.getId());
        // Assert
        verify(studentDAO, calls(1)).findById(stu.getId());
        assertTrue(CollectionUtils.isEqualCollection(initialList, stu.getSubjects()));
    }

}
