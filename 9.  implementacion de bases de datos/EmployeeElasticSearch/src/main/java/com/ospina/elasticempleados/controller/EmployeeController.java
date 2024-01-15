package com.ospina.elasticempleados.controller;

import com.ospina.elasticempleados.domain.Employee;
import com.ospina.elasticempleados.domain.dto.EmployeeDTO;
import com.ospina.elasticempleados.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/crear")
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.createEmployee(employeeDTO);
        return ResponseEntity.ok("Employee has been created.");
    }

    @GetMapping
    public ResponseEntity<Iterable<Employee>> getEmployee() {
        return ResponseEntity.ok(employeeService.getEmployees());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable String id, @RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, employeeDTO));
    }

}
