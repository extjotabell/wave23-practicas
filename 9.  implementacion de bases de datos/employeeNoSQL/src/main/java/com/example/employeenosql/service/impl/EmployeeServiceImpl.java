package com.example.employeenosql.service.impl;

import com.example.employeenosql.exceptions.IdNoExistsException;
import com.example.employeenosql.model.dto.EmployeeDTO;
import com.example.employeenosql.model.entity.Employee;
import com.example.employeenosql.repository.IEmployeeRepository;
import com.example.employeenosql.service.IEmployeeService;
import com.example.employeenosql.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private final IEmployeeRepository employeeRepository;

    public EmployeeServiceImpl(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = Mapper.mapToEmployee(employeeDTO);
        employee = employeeRepository.save(employee);
        return Mapper.mapToEmployeeDTO(employee);
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        if (!employeeRepository.existsById(employeeDTO.getId())) {
            throw new IdNoExistsException();
        }
        Employee employee = Mapper.mapToEmployee(employeeDTO);
        employee = employeeRepository.save(employee);
        return Mapper.mapToEmployeeDTO(employee);
    }
    @Override
    public List<EmployeeDTO> getAllEmployees(){
        Iterable<Employee> employeeIterable = employeeRepository.findAll();
        return StreamSupport.stream(employeeIterable.spliterator(), false).map(Mapper::mapToEmployeeDTO).toList();
    }
}
