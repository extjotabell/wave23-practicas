package com.example.empleadosnorelacional.service;

import com.example.empleadosnorelacional.entity.Empleado;
import com.example.empleadosnorelacional.repository.EmpleadoRepository;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {

  private final EmpleadoRepository empleadoRepository;

  public EmpleadoService(EmpleadoRepository empleadoRepository) {
    this.empleadoRepository = empleadoRepository;
  }

  public String save(Empleado empleado){
    empleadoRepository.save(empleado);
    return "Se guardo el empleado";
  }

  public Iterable<Empleado> getAll() {
    return empleadoRepository.findAll();
  }
}
