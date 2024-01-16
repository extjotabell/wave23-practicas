package com.example.Employees.service;

import com.example.Employees.dto.EmployeeDTO;

import java.util.List;

public interface IEmployeeService {
    EmployeeDTO save(EmployeeDTO employee);

    List<EmployeeDTO> getAllEmployees();
    List<EmployeeDTO> getEmployeesByAge(String age);
    List<EmployeeDTO> getEmployeesByAgeRange(String age);
    List<EmployeeDTO> getEmployeesByNames(String age);
}
