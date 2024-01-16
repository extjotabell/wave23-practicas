package com.example.Employees.service;

import com.example.Employees.dto.EmployeeDTO;
import com.example.Employees.dto.MessageDTO;
import com.example.Employees.entity.Employee;
import com.example.Employees.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    IEmployeeRepository repository;

    @Override
    public EmployeeDTO save(EmployeeDTO dto) {
        Employee employee = mapToEntity(dto);
        repository.save(employee);
        return new MessageDTO("Employee added successfully.");
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employeeList = StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .toList();

        return employeeList.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDTO> getEmployeesByAgeRange(String age) {
        List<Employee> employees = repository.findByAgeGreaterThan(age);
        return employees.stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public List<EmployeeDTO> getEmployeesByAge(String age) {
        List<Employee> employees = repository.findByAge(age);
        return employees.stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    public List<EmployeeDTO> getEmployeesByNames(String age) {
        List<Employee> employees = repository.findByName(age);
        return employees.stream()
                .map(this::mapToDTO)
                .toList();
    }

    private EmployeeDTO mapToDTO(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setLastname(employee.getLastname());
        dto.setName(employee.getName());
        dto.setCity(employee.getCity());
        dto.setProvince(employee.getProvince());
        return dto;
    }

    private Employee mapToEntity(EmployeeDTO dto){
        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setName(dto.getName());
        employee.setLastname(dto.getLastname());
        employee.setName(dto.getName());
        employee.setCity(dto.getCity());
        employee.setProvince(dto.getProvince());
        return employee;
    }
}
