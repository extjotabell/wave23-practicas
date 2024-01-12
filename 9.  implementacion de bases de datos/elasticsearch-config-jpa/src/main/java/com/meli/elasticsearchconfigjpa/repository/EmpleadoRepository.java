package com.meli.elasticsearchconfigjpa.repository;

import com.meli.elasticsearchconfigjpa.entity.Empleado;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpleadoRepository extends ElasticsearchRepository<Empleado, String> {

    @Query("{\"bool\": {\"filter\": {\"term\": {\"edad\": \"?0\"}}}}")
    List<Empleado> findByEdad(String edad);

    @Query("{\"bool\": {\"filter\": {\"range\": {\"edad\": {\"gt\": \"?0\"}}}}}")
    List<Empleado> findByEdadGreaterThan(String edad);

    @Query("{\"bool\": {\"filter\": {\"match\": {\"nombre\": \"?0\"}}}}")
    List<Empleado> findByName(String name);


}
