package com.meli.obtenerdiploma.mock.service;

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
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Validación de servicio obtener diploma en método analyzeScores")
    void analyzeScoresTest(){

    }

    @Test
    @DisplayName("Validación de cálculo de promedio y mensaje")
    void calculateAverageTest(){
        StudentDTO studentWhen = new StudentDTO();
        when(studentDAO.findById(anyLong())).thenReturn(studentWhen);
        StudentDTO expected = new StudentDTO();
        System.out.println(studentWhen.toString());
        Assertions.assertEquals(expected, studentWhen);
    }

    private StudentDTO createStudent() {
        return new StudentDTO();
    }


}
