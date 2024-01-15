package com.example.elasticspring.service;

import com.example.elasticspring.entity.Empleado;
import com.example.elasticspring.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

        List<Empleado> empleadoList = StreamSupport
                .stream(empleadoIterable.spliterator(), false)
                .collect(Collectors.toList());

        return empleadoList;
    }


    public List<Empleado> findByEdad(String edad) { return  empleadoRepository.findByEdad(edad);}

    public List<Empleado> findByEdadByRange(String edad){ return empleadoRepository.findByEdadGreaterThan(edad);}

    public List<Empleado> findByNames(String nombre){ return  empleadoRepository.findByNames(nombre);}



}
