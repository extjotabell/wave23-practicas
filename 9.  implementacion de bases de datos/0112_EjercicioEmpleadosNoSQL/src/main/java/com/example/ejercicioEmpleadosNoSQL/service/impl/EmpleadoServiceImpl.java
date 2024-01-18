package com.example.ejercicioEmpleadosNoSQL.service.impl;

import com.example.ejercicioEmpleadosNoSQL.dto.EmpleadoDto;
import com.example.ejercicioEmpleadosNoSQL.dto.MessageDto;
import com.example.ejercicioEmpleadosNoSQL.entity.Empleado;
import com.example.ejercicioEmpleadosNoSQL.repository.EmpleadoRepository;
import com.example.ejercicioEmpleadosNoSQL.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

   @Autowired
   private EmpleadoRepository empleadoRepository;

    @Override
    public MessageDto saveEmpleado(EmpleadoDto empleadoDto) {
        empleadoRepository.save(new Empleado(
                empleadoDto.getId(),
                empleadoDto.getNombre(),
                empleadoDto.getApellido(),
                empleadoDto.getEdad(),
                empleadoDto.getCiudad(),
                empleadoDto.getEstado()
        ));
        return new MessageDto("Ok");
    }

    @Override
    public List<EmpleadoDto> findAll() {

        List<Empleado> empleadoList = StreamSupport.stream(
                empleadoRepository.findAll().spliterator(), false)
                .toList();

        return empleadoList.stream()
                .map(e -> new EmpleadoDto(
                        e.getId(),
                        e.getNombre(),
                        e.getApellido(),
                        e.getEdad(),
                        e.getCiudad(),
                        e.getEstado()
                )).toList();
    }
}
