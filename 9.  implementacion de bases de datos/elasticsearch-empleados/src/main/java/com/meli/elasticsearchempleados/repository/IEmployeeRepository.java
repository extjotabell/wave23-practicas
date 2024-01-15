package com.meli.elasticsearchempleados.repository;

import com.meli.elasticsearchempleados.domain.Employee;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IEmployeeRepository extends ElasticsearchRepository<Employee, String> {

    @Query("{\"match\": {\"name\": {\"query\": \"?0\"}}}")
    Iterable<Employee> findByName(String name);

    @Query("{\"bool\": {\"filter\": [{\"term\": {\"age\": \"?0\"}}]}}")
    Iterable<Employee> findByAge(Integer age);

    @Query("{\"bool\": {\"filter\": [{\"range\": {\"age\": {\"gte\": \"?0\"}}}]}}")
    Iterable<Employee> findByAgeGreaterThan(Integer age);
}
