package com.demospring.demo.service;

import com.demospring.demo.dto.ListAllAlumnosDTO;
import com.demospring.demo.dto.MateriaDTO;
import com.demospring.demo.dto.AlumnoDTO;
import com.demospring.demo.dto.MessageDTO;
import com.demospring.demo.entity.Alumno;
import com.demospring.demo.entity.Materia;
import com.demospring.demo.exceptions.ListaVaciaException;
import com.demospring.demo.exceptions.IdNoEncontradoException;
import com.demospring.demo.repository.AlumnoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlumnoService implements IAlumnoService {

    ModelMapper mapper = new ModelMapper();

    @Autowired
    AlumnoRepository alumnoRepository;

    @Override
    public AlumnoDTO createAlumno(AlumnoDTO alumnoDTO) {

        Alumno alumno = mapper.map(alumnoDTO, Alumno.class);

        Alumno alumnoAgregado = alumnoRepository.addAlumno(alumno);

        return mapper.map(alumnoAgregado, AlumnoDTO.class);
    }

    @Override
    public MessageDTO deleteAlumno(String dni) {
        String message = alumnoRepository.deleteAlumno(dni);
        return new MessageDTO(message);
    }

    @Override
    public AlumnoDTO findById(String dni) {
        Alumno alumnoFound = alumnoRepository.findById(dni)
                .orElseThrow(
                        () -> {
                            throw new IdNoEncontradoException("No se encontro alumno con dni: " + dni);
                        }
                );

        AlumnoDTO alumnoDTO = mapper.map(alumnoFound, AlumnoDTO.class);


        return alumnoDTO;
    }

    @Override
    public ListAllAlumnosDTO findAll() {
        List<Alumno> listAlumno = alumnoRepository.findAll();

        if (listAlumno.isEmpty()) 
            throw new ListaVaciaException("No se encontro nada en la lista de: ", "Alumnos");

        var listDTOs = listAlumno.stream().map(
                a -> mapper.map(a, AlumnoDTO.class)
        ).collect(Collectors.toList());

        return new ListAllAlumnosDTO(listDTOs);

    }
}
