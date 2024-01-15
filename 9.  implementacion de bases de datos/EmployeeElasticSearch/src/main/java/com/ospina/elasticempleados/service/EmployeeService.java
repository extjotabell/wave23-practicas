package com.ospina.elasticempleados.service;

import com.ospina.elasticempleados.domain.Employee;
import com.ospina.elasticempleados.domain.dto.EmployeeDTO;
import com.ospina.elasticempleados.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository empleadoRepositorio;

    public EmployeeService(EmployeeRepository empleadoRepositorio) {
        this.empleadoRepositorio = empleadoRepositorio;
    }

    public void createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = mapToEmployee(employeeDTO);
        empleadoRepositorio.save(employee);
    }

    public Iterable<Employee> getEmployees() {
        return empleadoRepositorio.findAll();
    }

    public Employee updateEmployee(String id, EmployeeDTO employeeDTO) {
        Employee employee = empleadoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("An employee with the provided id was not found: " + id));
        employee.setName(employeeDTO.getName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setAge(employeeDTO.getAge());
        employee.setCity(employeeDTO.getCity());
        employee.setDepartment(employeeDTO.getDepartment());
        empleadoRepositorio.save(employee);
        return employee;
    }

    private Employee mapToEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setAge(employeeDTO.getAge());
        employee.setCity(employeeDTO.getCity());
        employee.setDepartment(employeeDTO.getDepartment());
        return employee;
    }


}
