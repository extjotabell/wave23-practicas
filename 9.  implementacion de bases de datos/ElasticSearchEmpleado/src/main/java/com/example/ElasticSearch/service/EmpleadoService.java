package com.example.ElasticSearch.service;

import com.example.ElasticSearch.entity.Empleado;
import com.example.ElasticSearch.repository.IEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


@Service
public class EmpleadoService {

    @Autowired
    private IEmpleadoRepository empleadoRepository;

    public Empleado save(Empleado empleado){
        return  empleadoRepository.save(empleado);
    }

    public List<Empleado> getAll() {

        Iterable<Empleado> empleadosIterable = empleadoRepository.findAll();

        List<Empleado> empleados = StreamSupport.stream(empleadosIterable.spliterator(),false)
                .collect(Collectors.toList());

        return empleados;
    }

    public List<Empleado> findByEdad(String edad){
        return empleadoRepository.findByEdad(edad);
    }

    public List<Empleado> findByEdadRange(String edad){
        return empleadoRepository.findByEdadRange(edad);
    }

    public List<Empleado> findByName(String nombre){
        return empleadoRepository.findByName(nombre);
    }
}
