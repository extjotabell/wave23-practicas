package com.example.employeenosql.utils;

import com.example.employeenosql.model.dto.EmployeeDTO;
import com.example.employeenosql.model.entity.Employee;

public class Mapper {

    private Mapper() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static EmployeeDTO mapToEmployeeDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setNameEmployee(employee.getNameEmployee());
        employeeDTO.setLastNameEmployee(employee.getLastNameEmployee());
        employeeDTO.setAgeEmployee(employee.getAgeEmployee());
        employeeDTO.setCityEmployee(employee.getCityEmployee());
        employeeDTO.setProvinceEmployee(employee.getProvinceEmployee());
        return employeeDTO;
    }

    public static Employee mapToEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setNameEmployee(employeeDTO.getNameEmployee());
        employee.setLastNameEmployee(employeeDTO.getLastNameEmployee());
        employee.setAgeEmployee(employeeDTO.getAgeEmployee());
        employee.setCityEmployee(employeeDTO.getCityEmployee());
        employee.setProvinceEmployee(employeeDTO.getProvinceEmployee());
        return employee;
    }
}
