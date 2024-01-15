package com.example.clasenosql.service;

import com.example.clasenosql.entity.Empleado;
import com.example.clasenosql.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmpleadoService implements IEmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;


    @Override
    public Empleado save(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public List<Empleado> getAll() {
        Iterable<Empleado> empleadoIterable = empleadoRepository.findAll();

        return StreamSupport
                .stream(empleadoIterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<Empleado> findByEdad(String edad) { return  empleadoRepository.findByEdad(edad);}

    @Override
    public List<Empleado> findByEdadByRange(String edad){ return empleadoRepository.findByEdadGreaterThan(edad);}

    @Override
    public List<Empleado> findByNames(String nombre){ return  empleadoRepository.findByNames(nombre);}

}
