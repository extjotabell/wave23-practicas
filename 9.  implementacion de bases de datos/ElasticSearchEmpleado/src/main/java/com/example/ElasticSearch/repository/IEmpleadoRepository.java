package com.example.ElasticSearch.repository;

import com.example.ElasticSearch.entity.Empleado;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IEmpleadoRepository extends ElasticsearchRepository<Empleado,String> {

    @Query("{\"bool\": {\filter\": [{\"term\": {\"edad\": \"?0\"}}]}}")
     List<Empleado> findByEdad(String edad);

    @Query("{\"bool\": {\filter\": [{\"range\": {\"edad\":{\"gte\": \"?0\"}}}]}}")
    List<Empleado> findByEdadRange(String edad);


    @Query("{\"match\": {\"nombre\":{\"query\": \"?0\"}}}")
    List<Empleado> findByName(String nombre);

}
