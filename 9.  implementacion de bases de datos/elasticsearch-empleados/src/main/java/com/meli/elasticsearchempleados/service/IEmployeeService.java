package com.meli.elasticsearchempleados.service;

import com.meli.elasticsearchempleados.domain.DTO.EmployeeDTO;
import com.meli.elasticsearchempleados.domain.DTO.EmployeesDTO;

public interface IEmployeeService {
    EmployeeDTO save(EmployeeDTO employee);
    EmployeesDTO findAll();
    EmployeesDTO findByName(String name);
    EmployeesDTO findByAge(Integer age);
    EmployeesDTO findByAgeGreaterThan(Integer age);
}
