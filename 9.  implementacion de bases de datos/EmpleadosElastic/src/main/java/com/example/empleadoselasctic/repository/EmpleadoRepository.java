package com.example.empleadoselasctic.repository;

import com.example.empleadoselasctic.entity.Empleado;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmpleadoRepository extends ElasticsearchRepository<Empleado, String> {
    @Query("{\"bool\": {\"filter\": [{\"term\": {\"edad\": \"?0\"}}]}}")
    List<Empleado> findByEdad(String edad);
    @Query("{\"bool\": {\"filter\": [{\"range\": {\"edad\":{\"gte\": \"?0\"}}}]}}")
    List<Empleado> findByEdadByRange(String edad);
    @Query("{\"match\": {\"nombre\":{\"query\": \"?0\"}}}")
    List<Empleado> findByNames(String nombre);
    List<Empleado> findByEdadGreaterThan(String edad);
}
