package com.meli.bootcamp.empleados.repository;

import com.meli.bootcamp.empleados.entity.Empleado;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadoRepository extends ElasticsearchRepository<Empleado,String> {
}
