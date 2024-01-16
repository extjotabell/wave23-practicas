package com.example.Employees.controller;

import com.example.Employees.dto.EmployeeDTO;
import com.example.Employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    EmployeeService service;

    @PostMapping("/new")
    public ResponseEntity<?> addEmployee(@RequestBody EmployeeDTO employee){
        return new ResponseEntity<>(service.save(employee), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllEmployees(){
        return new ResponseEntity<>(service.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/find-by-age/{age}")
    public ResponseEntity<?> getEmployeesByAge(String age){
        return new ResponseEntity<>(service.getEmployeesByAge(age), HttpStatus.OK);
    }

    @GetMapping("/find-by-age-greater/{age}")
    public ResponseEntity<?> getEmployeesByAgeGreater(String age){
        return new ResponseEntity<>(service.getEmployeesByAgeRange(age), HttpStatus.OK);
    }

    @GetMapping("/find-by-name/{name}")
    public ResponseEntity<?> getEmployeesByName(String name){
        return new ResponseEntity<>(service.getEmployeesByNames(name), HttpStatus.OK);
    }

}
