package com.example.employeenosql.repository;

import com.example.employeenosql.model.entity.Employee;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends ElasticsearchRepository<Employee, String> {

}
