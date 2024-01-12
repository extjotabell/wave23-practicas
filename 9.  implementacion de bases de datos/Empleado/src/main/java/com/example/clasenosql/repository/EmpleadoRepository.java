package com.example.clasenosql.repository;

import com.example.clasenosql.entity.Empleado;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends ElasticsearchRepository<Empleado, String> {


    @Query("{\"bool\": {\"filter\": [{\"term\": {\"edad\": \"?0\"}}]}}")
    public List<Empleado> findByEdad(String edad);

    @Query("{\"bool\": {\"filter\": [{\"range\": {\"edad\":{\"gte\": \"?0\"}}}]}}")
    public List<Empleado> findByEdadByRange(String edad);

    @Query("{\"match\": {\"nombre\":{\"query\": \"?0\"}}}")
    public  List<Empleado> findByNames(String nombre);

    public List<Empleado> findByEdadGreaterThan(String edad);

}
