package org.ejercicio.elasticsearch.repository;

import org.ejercicio.elasticsearch.model.entity.Employee;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends ElasticsearchRepository<Employee, String> {

    @Query("{\"match\": {\"name\":{\"query\": \"?0\"}}}")
    List<Employee> findByName(String name);
}
