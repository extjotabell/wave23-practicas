package com.example.elasticsearch.controller;

import com.example.elasticsearch.domain.Employee;
import com.example.elasticsearch.dto.EmployeeDTO;
import com.example.elasticsearch.service.EmployeeServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeServiceImp service;

    public EmployeeController(EmployeeServiceImp service) {
        this.service = service;
    }

    @PostMapping (path = "/addEmployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(service.addEmployee(employeeDTO));
    }

    @GetMapping (path = "/getEmployees")
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/findByAge/{age}")
    public ResponseEntity<List<Employee>> findByAge(@PathVariable String age) {
        return ResponseEntity.ok(service.findByAge(age));
    }

    /*@GetMapping("/findByAgeRange/{age}")
    public ResponseEntity<List<Employee>> findByAgeRange(@PathVariable String age) {
        return ResponseEntity.ok(service.findByAgeRange(age));
    }*/

    @GetMapping("/findByName/{name}")
    public ResponseEntity<List<Employee>> findByName(@PathVariable String name) {
        return ResponseEntity.ok(service.findByName(name));
    }
}
