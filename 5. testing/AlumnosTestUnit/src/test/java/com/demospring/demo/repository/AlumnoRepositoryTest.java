package com.demospring.demo.repository;

import com.demospring.demo.entity.Alumno;
import com.demospring.demo.entity.Materia;
import com.demospring.demo.exceptions.AlumnoYaExisteException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class AlumnoRepositoryTest {

    AlumnoRepository alumnoRepository = new AlumnoRepository();

    @Test
    void addAlumnoTest(){
        //ARRAGNGE - preparar datos a usar: parametros y tipos de datos de la devolucion
        Alumno param = new Alumno("40", "Jean", LocalDate.now(),25,
                List.of(new Materia("1", "Matematicas", 90.0),
                        new Materia("2", "Literatura", 100.0)
                )
        );
        Alumno devolucion = param;

        //ACT - correr el metodo del repositorio
        var obtenido = alumnoRepository.addAlumno(param);

        //ASSERT - probar la condicion
        Assertions.assertEquals(devolucion,obtenido);

    }

    @Test
    void addAlumnoSadPathTest(){
        //ARRAGNGE
        Alumno param = new Alumno("4040", "Jean", LocalDate.of(1998,02,05),25,
                List.of(new Materia("1", "Matematicas", 9D)
                )
        );

        //ACT - ASSERT
        Assertions.assertThrows(AlumnoYaExisteException.class,
                () -> {alumnoRepository.addAlumno(param);});

    }
}
