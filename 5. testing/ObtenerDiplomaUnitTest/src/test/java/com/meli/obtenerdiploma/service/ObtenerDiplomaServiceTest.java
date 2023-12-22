package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void greettingMessageBelow9(){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Juan");
        studentDTO.setSubjects(List.of(new SubjectDTO("Matematicas",8.5)));
        when(studentDAO.findById(1L)).thenReturn(studentDTO);
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);
        assertEquals("El alumno Juan ha obtenido un promedio de 8.5. Puedes mejorar.", result.getMessage());
    }
    @Test
    public void greettingMessageAbove9(){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Juan");
        studentDTO.setSubjects(List.of(new SubjectDTO("Matematicas",9.2)));
        when(studentDAO.findById(1L)).thenReturn(studentDTO);
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);
        assertEquals("El alumno Juan ha obtenido un promedio de 9.2. Felicitaciones!", result.getMessage());
    }

    @Test
    public void averageTest(){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Juan");
        studentDTO.setSubjects(List.of(new SubjectDTO("Matematicas",9.2)
                ,new SubjectDTO("Fisica",8.3) ));
        when(studentDAO.findById(1L)).thenReturn(studentDTO);
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);
        assertEquals(8.75, result.getAverageScore());
    }

    @Test
    public void analyzeScoresNotNull(){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Juan");
        studentDTO.setSubjects(List.of(new SubjectDTO("Matematicas",9.2)
                ,new SubjectDTO("Fisica",8.3) ));
        when(studentDAO.findById(1L)).thenReturn(studentDTO);
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);
        assertNotNull(result);
    }

}
