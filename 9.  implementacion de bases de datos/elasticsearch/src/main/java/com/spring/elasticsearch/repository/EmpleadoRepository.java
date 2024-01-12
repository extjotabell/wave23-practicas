package com.spring.elasticsearch.repository;

import com.spring.elasticsearch.model.Empleado;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends ElasticsearchRepository<Empleado, String> {

    @Query("{\"bool\": {\"filter\": [{\"term\":{\"edad\":\"?0\"}}}}}")
    public List<Empleado> findByEdad(Integer edad);
}
