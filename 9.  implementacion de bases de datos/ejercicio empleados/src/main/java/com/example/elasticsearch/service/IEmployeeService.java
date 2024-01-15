package com.example.elasticsearch.service;

import com.example.elasticsearch.domain.Employee;
import com.example.elasticsearch.dto.EmployeeDTO;

import java.util.List;

public interface IEmployeeService {
    Employee addEmployee(EmployeeDTO employeeDTO);
    List<Employee> getAll();
    List<Employee> findByAge(String age);
    //List<Employee> findByAgeRange(String age);
    List<Employee> findByName(String name);
}
