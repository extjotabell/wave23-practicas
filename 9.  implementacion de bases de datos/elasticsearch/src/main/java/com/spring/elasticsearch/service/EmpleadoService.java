package com.spring.elasticsearch.service;

import com.spring.elasticsearch.model.Empleado;
import com.spring.elasticsearch.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository repository;

    public Empleado saveEmpleado(Empleado empleado){
        return repository.save(empleado);
    }

    public List<Empleado> getAll(){
        return StreamSupport.stream(repository.findAll().spliterator(), false).toList();
    }

}
