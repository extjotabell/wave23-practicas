package com.meli.Empleados.service;

import com.meli.Empleados.dto.EmpleadoDto;
import com.meli.Empleados.entity.Empleado;
import com.meli.Empleados.exception.NotFoundException;
import com.meli.Empleados.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    EmpleadoRepository repository;

    public EmpleadoServiceImpl(EmpleadoRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<EmpleadoDto> findAll() {
        Iterable<Empleado> empleados = repository.findAll();

        return StreamSupport.stream(empleados.spliterator(), false)
            .map(EmpleadoDto::new)
            .toList();
    }

    @Override
    public EmpleadoDto findById(String id) {
        Empleado empleado = repository.findById(id).orElseThrow(() -> new NotFoundException("Empleado no encontrado"));
        return new EmpleadoDto(empleado);
    }

    @Override
    public EmpleadoDto save(EmpleadoDto empleado) {
        Empleado empleadoToSave = new Empleado(empleado);
        Empleado empleadoSaved = repository.save(empleadoToSave);
        return new EmpleadoDto(empleadoSaved);
    }

    @Override
    public void deleteById(String id) {
        repository.findById(id).orElseThrow(() -> new NotFoundException("Empleado no encontrado"));
        repository.deleteById(id);
    }
}
