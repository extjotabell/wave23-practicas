package com.example.Employees.repository;

import com.example.Employees.entity.Employee;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IEmployeeRepository extends ElasticsearchRepository<Employee, String> {
    @Query("{\"bool\": {\"filter\": [{\"term\": {\"age\": \"?0\"}}]}}")
    List<Employee> findByAge(String age);

    @Query("{\"bool\": {\"filter\": [{\"range\": {\"age\":{\"gte\": \"?0\"}}}}]}}")
    List<Employee> findByAgeRange(String age);

    @Query("{\"match\": {\"name\":{\"query\": \"?0\"}}}")
    List<Employee> findByName(String age);

    List<Employee> findByAgeGreaterThan(String age);
}
