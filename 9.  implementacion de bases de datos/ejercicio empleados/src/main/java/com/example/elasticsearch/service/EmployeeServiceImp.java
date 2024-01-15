package com.example.elasticsearch.service;

import com.example.elasticsearch.domain.Employee;
import com.example.elasticsearch.dto.EmployeeDTO;
import com.example.elasticsearch.repository.IEmployeeRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmployeeServiceImp implements IEmployeeService {
    private final IEmployeeRepo repo;
    private final ObjectMapper modelMapper = new ObjectMapper();

    public EmployeeServiceImp(IEmployeeRepo repo) {
        this.repo = repo;
    }

    @Override
    public Employee addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = modelMapper.convertValue(employeeDTO, Employee.class);
        return repo.save(employee);
    }

    public List<Employee> getAll() {
        Iterable<Employee> employeesIterable = repo.findAll();
        return StreamSupport.stream(employeesIterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    public List<Employee> findByAge(String age) { return  repo.findByAge(age);}

    //public List<Employee> findByAgeRange(String age){ return repo.findByAgeRange(age);}

    public List<Employee> findByName(String name){ return repo.findByName(name);}
}
