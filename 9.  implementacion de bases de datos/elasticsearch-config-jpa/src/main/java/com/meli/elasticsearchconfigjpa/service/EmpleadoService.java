package com.meli.elasticsearchconfigjpa.service;

import com.meli.elasticsearchconfigjpa.entity.Empleado;
import com.meli.elasticsearchconfigjpa.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public Empleado save(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public List<Empleado> getAll() {
        Iterable<Empleado> empleadoIterable = empleadoRepository.findAll();
        return StreamSupport.stream(empleadoIterable.spliterator(), false).toList();
    }

    public List<Empleado> findByEdad(String edad){
        return empleadoRepository.findByEdad(edad);
    }


    public List<Empleado> findByEdadMayor(String edad) {
        return empleadoRepository.findByEdadGreaterThan(edad);
    }

    public List<Empleado> findByName(String name) {
        return empleadoRepository.findByName(name);
    }
}
