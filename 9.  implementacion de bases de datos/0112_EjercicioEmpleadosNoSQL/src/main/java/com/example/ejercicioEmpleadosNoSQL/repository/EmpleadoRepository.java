package com.example.ejercicioEmpleadosNoSQL.repository;

import com.example.ejercicioEmpleadosNoSQL.entity.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends ElasticsearchRepository<Empleado, Integer> {

}
