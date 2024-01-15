package com.meli.Empleados.repository;

import com.meli.Empleados.entity.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EmpleadoRepository extends ElasticsearchRepository<Empleado, String> {
}