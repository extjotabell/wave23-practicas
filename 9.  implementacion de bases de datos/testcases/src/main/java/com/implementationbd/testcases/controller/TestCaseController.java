package com.implementationbd.testcases.controller;

import com.implementationbd.testcases.dto.TestCaseDto;
import com.implementationbd.testcases.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    private final ITestCaseService service;

    public TestCaseController(ITestCaseService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public ResponseEntity<Void> create(@RequestBody TestCaseDto testCaseDto) {
        service.save(testCaseDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    @GetMapping()
//    public ResponseEntity<List<TestCaseDto>> getAll() {
//        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDto> getById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody TestCaseDto testCaseDto) {
        service.update(id, testCaseDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<TestCaseDto> getTestCasesUpdatedAfterDate(@RequestParam("last_update") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate lastUpdate) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
