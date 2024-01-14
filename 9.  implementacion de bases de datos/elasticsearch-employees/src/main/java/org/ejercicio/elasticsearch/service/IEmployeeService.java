package org.ejercicio.elasticsearch.service;

import org.ejercicio.elasticsearch.model.dto.EmployeeDTO;
import org.ejercicio.elasticsearch.model.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee saveEmployee(EmployeeDTO employeeDTO);

    List<Employee> getEmployees();

    void deleteEmployee(String employeeId);

    Employee modifyEmployee(EmployeeDTO employeeDTO);

    List<Employee> getEmployeesByName(String name);
}
