package com.demospring.demo.service;

import com.demospring.demo.dto.AlumnoDTO;
import com.demospring.demo.dto.MateriaDTO;
import com.demospring.demo.entity.Alumno;
import com.demospring.demo.entity.Materia;
import com.demospring.demo.exceptions.IdNoEncontradoException;
import com.demospring.demo.repository.AlumnoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class AlumnoServiceTest {

    ModelMapper mapper = new ModelMapper();

    @Mock
    AlumnoRepository alumnoRepository;

    @InjectMocks
    AlumnoService alumnoService;

    @Test
    void createAlumnoTest(){
        //ARRAGE
        AlumnoDTO param = new AlumnoDTO("40", "Jean", LocalDate.now(),25,
                List.of(new MateriaDTO("1", "Matematicas", 9D),
                        new MateriaDTO("2", "Literatura", 10D)
                )
        );
        AlumnoDTO devolucion = param;

        Alumno paramMock = mapper.map(param,Alumno.class);

        //ACT
        Mockito.when(alumnoRepository.addAlumno(paramMock)).thenReturn(paramMock);

        var obtenido = alumnoService.createAlumno(param);

        //ASSERT
        Assertions.assertEquals(devolucion,obtenido);
    }

    @Test
    void findByIdNOKTest(){
        //ARRAGE
        String dni = "4040";

        //ACT and ASSERT
        Mockito.when(alumnoRepository.findById(dni)).thenReturn(Optional.empty());
        Assertions.assertThrows(IdNoEncontradoException.class,
                () -> alumnoService.findById(dni));
    }
}
