package org.bootcamp.empleados.service;

import org.bootcamp.empleados.model.entity.Empleado;
import org.bootcamp.empleados.repository.IEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ObraServiceImpl implements IEmpleadoService{

    @Autowired
    IEmpleadoRepository repository;


    @Override
    public Empleado save(Empleado empleado) {
        return repository.save(empleado);
    }

    @Override
    public List<Empleado> listAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Empleado update(Empleado empleado) {
        Empleado empleado_upd = StreamSupport.stream(repository.findAll().spliterator(), false)
                .filter(e -> e.getNombre().equals(empleado))
                .findFirst()
                .get();

        empleado_upd.setNombre(empleado.getNombre());
        empleado_upd.setApellido(empleado.getApellido());
        empleado_upd.setEdad(empleado.getEdad());
        empleado_upd.setCiudad(empleado.getCiudad());
        empleado_upd.setProvincia(empleado.getProvincia());

        return repository.save(empleado_upd);
    }

}
