package com.meli.elasticsearchempleados.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.elasticsearchempleados.domain.DTO.EmployeeDTO;
import com.meli.elasticsearchempleados.domain.DTO.EmployeesDTO;
import com.meli.elasticsearchempleados.domain.Employee;
import com.meli.elasticsearchempleados.repository.IEmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    private final IEmployeeRepository repository;
    private ObjectMapper mapper = new ObjectMapper();

    public EmployeeServiceImpl(IEmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        repository.save(mapper.convertValue(employeeDTO, Employee.class));
        return employeeDTO;
    }

    @Override
    public EmployeesDTO findAll() {
        Iterable<Employee> employeeIterable = repository.findAll();
        return new EmployeesDTO(mapIterableEmployeeToListEmployeeDTO(employeeIterable));
    }

    @Override
    public EmployeesDTO findByName(String name) {
        Iterable<Employee> employeeIterable = repository.findByName(name);
        return new EmployeesDTO(mapIterableEmployeeToListEmployeeDTO(employeeIterable));
    }

    @Override
    public EmployeesDTO findByAge(Integer age) {
        Iterable<Employee> employeeIterable = repository.findByAge(age);
        return new EmployeesDTO(mapIterableEmployeeToListEmployeeDTO(employeeIterable));    }

    @Override
    public EmployeesDTO findByAgeGreaterThan(Integer age) {
        Iterable<Employee> employeeIterable = repository.findByAgeGreaterThan(age);
        return new EmployeesDTO(mapIterableEmployeeToListEmployeeDTO(employeeIterable));    }

    private List<EmployeeDTO> mapIterableEmployeeToListEmployeeDTO(Iterable<Employee> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(employee -> mapper.convertValue(employee, EmployeeDTO.class))
                .toList();
    }
}
