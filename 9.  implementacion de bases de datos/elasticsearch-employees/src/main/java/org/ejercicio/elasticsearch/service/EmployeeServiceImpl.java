package org.ejercicio.elasticsearch.service;

import org.ejercicio.elasticsearch.model.dto.EmployeeDTO;
import org.ejercicio.elasticsearch.model.entity.Employee;
import org.ejercicio.elasticsearch.repository.IEmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private final IEmployeeRepository repository;

    public EmployeeServiceImpl(IEmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(employeeDTO.getName(), employeeDTO.getSurname(), employeeDTO.getAge(), employeeDTO.getProvince(), employeeDTO.getCity());
        return repository.save(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        Iterable<Employee> employees = repository.findAll();

        return StreamSupport
                .stream(employees.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteEmployee(String employeeId) {
        repository.deleteById(employeeId);
    }

    @Override
    public Employee modifyEmployee(EmployeeDTO employeeDTO) {
        Employee employee = repository.findById(employeeDTO.getId()).orElse(null);
        employee.setName(employeeDTO.getName());
        employee.setSurname(employeeDTO.getSurname());
        employee.setAge(employeeDTO.getAge());
        employee.setProvince(employeeDTO.getProvince());
        employee.setCity(employeeDTO.getCity());
        return repository.save(employee);
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return repository.findByName(name);
    }
}
