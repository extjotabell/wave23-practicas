package com.meli.elasticsearchempleados.controller;

import com.meli.elasticsearchempleados.domain.DTO.EmployeeDTO;
import com.meli.elasticsearchempleados.service.EmployeeServiceImpl;
import com.meli.elasticsearchempleados.service.IEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employees")
public class EmployeeController {
    IEmployeeService service;

    public EmployeeController(EmployeeServiceImpl service) { this.service = service; }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody EmployeeDTO employeeDTO) {
        return new ResponseEntity<>(service.save(employeeDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/find-by-name/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) {
        return new ResponseEntity<>(service.findByName(name), HttpStatus.OK);
    }
    
    @GetMapping("/find-by-age/{age}")
    public ResponseEntity<?> findByAge(@PathVariable Integer age) {
        return new ResponseEntity<>(service.findByAge(age), HttpStatus.OK);
    }

    @GetMapping("/greater-than/{age}")
    public ResponseEntity<?> findByAgeGreaterThan(@PathVariable Integer age) {
        return new ResponseEntity<>(service.findByAgeGreaterThan(age), HttpStatus.OK);
    }
}
