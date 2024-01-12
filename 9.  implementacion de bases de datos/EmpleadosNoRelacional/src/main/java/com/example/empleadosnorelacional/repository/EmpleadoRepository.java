package com.example.empleadosnorelacional.repository;

import com.example.empleadosnorelacional.entity.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

  public interface EmpleadoRepository extends ElasticsearchRepository<Empleado, String> {

}
