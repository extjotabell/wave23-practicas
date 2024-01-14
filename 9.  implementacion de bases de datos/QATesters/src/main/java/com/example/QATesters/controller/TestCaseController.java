package com.example.QATesters.controller;

import com.example.QATesters.dto.TestCaseDTO;
import com.example.QATesters.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    @Autowired
    TestCaseService service;

    @PostMapping("/new")
    public ResponseEntity<?> addTestCase(@RequestBody TestCaseDTO testCaseDTO){
        return new ResponseEntity<>(service.addTestCase(testCaseDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllTestCases(){
        return new ResponseEntity<>(service.getAllTestCases(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTestCaseByID(@PathVariable Long id){
        return new ResponseEntity<>(service.getTestCaseByID(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTestCase(@PathVariable Long id, @RequestBody TestCaseDTO testCaseDTO){
        return new ResponseEntity<>(service.updateTestCase(id, testCaseDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestCase(@PathVariable Long id){
        return new ResponseEntity<>(service.deleteTestCase(id), HttpStatus.OK);
    }

    @GetMapping(params = "last_update")
    public ResponseEntity<?> getTestCaseByLastUpdate(
            @RequestParam("last_update") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate lastUpdate){
        return new ResponseEntity<>(service.getTestCasePostDate(lastUpdate), HttpStatus.OK);
    }
}
