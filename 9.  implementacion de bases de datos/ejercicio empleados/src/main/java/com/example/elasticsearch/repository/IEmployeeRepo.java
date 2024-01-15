package com.example.elasticsearch.repository;

import com.example.elasticsearch.domain.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEmployeeRepo extends ElasticsearchRepository<Employee, Long> {
    @Query("{\"bool\": {\"filter\": [{\"term\": {\"age\": \"?0\"}}]}}")
    List<Employee> findByAge(String age);

    /*@Query("{\"bool\": {\"filter\": [{\"range\": {\"age\":{\"gte\": \"?0\"}}}]}}")
    List<Employee> findByAgeRange(String age);*/

    @Query("{\"match\": {\"name\":{\"query\": \"?0\"}}}")
    List<Employee> findByName(String name);
}