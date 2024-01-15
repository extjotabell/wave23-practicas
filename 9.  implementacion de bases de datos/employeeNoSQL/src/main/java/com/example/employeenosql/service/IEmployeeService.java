package com.example.employeenosql.service;

import com.example.employeenosql.model.dto.EmployeeDTO;

import java.util.List;

public interface IEmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);
    List<EmployeeDTO> getAllEmployees();
}
