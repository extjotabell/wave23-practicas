package com.example.empleados.service;

import com.example.empleados.entity.Empleado;
import com.example.empleados.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;


    public Empleado save(Empleado empleado){
        return empleadoRepository.save(empleado);
    }

    public List<Empleado> getAll(){
        Iterable<Empleado> empleadoIterable = empleadoRepository.findAll();

        return StreamSupport
                .stream(empleadoIterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    public Empleado update(String id, Empleado newEmpleado){
        Empleado empleado = this.findById(id);

        if (newEmpleado.getNombre() != null) empleado.setNombre(newEmpleado.getNombre());

        if (newEmpleado.getApellido() != null) empleado.setApellido(newEmpleado.getApellido());

        if (newEmpleado.getEdad() != null) empleado.setEdad(newEmpleado.getEdad());

        if (newEmpleado.getCiudad() != null) empleado.setCiudad(newEmpleado.getCiudad());

        if (newEmpleado.getProvincia() != null) empleado.setProvincia(newEmpleado.getProvincia());

        return empleadoRepository.save(empleado);
    }

    public Empleado findById(String id) {
        return empleadoRepository.findById(id).orElse(null);
    }
}
