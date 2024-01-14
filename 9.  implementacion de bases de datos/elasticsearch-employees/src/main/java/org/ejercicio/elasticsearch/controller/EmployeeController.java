package org.ejercicio.elasticsearch.controller;

import org.ejercicio.elasticsearch.model.dto.EmployeeDTO;
import org.ejercicio.elasticsearch.service.EmployeeServiceImpl;
import org.ejercicio.elasticsearch.service.IEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final IEmployeeService service;

    public EmployeeController(EmployeeServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getEmployees() {
        return new ResponseEntity<>(service.getEmployees(), HttpStatus.OK);
    }

    @GetMapping("/find-by-name/{name}")
    public ResponseEntity<?> getEmployeesByName(@PathVariable String name) {
        return new ResponseEntity<>(service.getEmployeesByName(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return new ResponseEntity<>(service.saveEmployee(employeeDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String employeeId) {
        service.deleteEmployee(employeeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> modifyEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return new ResponseEntity<>(service.modifyEmployee(employeeDTO), HttpStatus.OK);
    }
}
