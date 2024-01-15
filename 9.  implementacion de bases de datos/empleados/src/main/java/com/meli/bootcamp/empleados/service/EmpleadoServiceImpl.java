package com.meli.bootcamp.empleados.service;

import com.meli.bootcamp.empleados.dto.EmpleadoDto;
import com.meli.bootcamp.empleados.entity.Empleado;
import com.meli.bootcamp.empleados.repository.IEmpleadoRepository;
import com.meli.bootcamp.empleados.util.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{
    private IEmpleadoRepository empleadoRepository;

    public EmpleadoServiceImpl(IEmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public EmpleadoDto save(EmpleadoDto empleadoDto) {
        return Mapper.mapToEmpleadoDTO(empleadoRepository.save(Mapper.mapToEmpleado(empleadoDto)));
    }

    @Override
    public EmpleadoDto updateEmpleadoById(EmpleadoDto empleadoDto) {
        Empleado empleado = empleadoRepository.findById(empleadoDto.getId()).orElse(null);
        empleado.setNombre(empleadoDto.getNombre());
        empleado.setApellido(empleadoDto.getApellido());
        empleado.setEdad(empleadoDto.getEdad());
        empleado.setProvincia(empleadoDto.getProvincia());
        empleado.setCuidad(empleadoDto.getCuidad());
        return Mapper.mapToEmpleadoDTO(empleadoRepository.save(empleado));
    }

    @Override
    public List<EmpleadoDto> findAll() {
        Iterable<Empleado> obraIterable = empleadoRepository.findAll();
        List<Empleado> empleados = StreamSupport
                .stream(obraIterable.spliterator(),false)
                .collect(Collectors.toList());
        return empleados
                .stream()
                .map(empleado -> Mapper.mapToEmpleadoDTO(empleado))
                .collect(Collectors.toList());
    }


}
