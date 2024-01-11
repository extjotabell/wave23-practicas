package com.meli.tests.controllers;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.meli.tests.dtos.request.TestCaseDTO;
import com.meli.tests.services.ITestCaseService;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/testcases")
public class TestCaseController {

    private final ITestCaseService testCaseService;

    public TestCaseController(ITestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @GetMapping
    public ResponseEntity<List<TestCaseDTO>> getAllTestCases(@RequestParam(value = "last_update",required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate lastUpdate){
        return new ResponseEntity<>(testCaseService.getAllTestCases(Optional.ofNullable(lastUpdate)), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDTO> getTestCaseById(@PathVariable Long id){
        return new ResponseEntity<>(testCaseService.getTestCaseById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TestCaseDTO> createTestCase(@RequestBody TestCaseDTO testCaseDTO){
        return new ResponseEntity<>(testCaseService.createTestCase(testCaseDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseDTO> updateTestCase(@PathVariable Long id, @RequestBody TestCaseDTO testCaseDTO){
        return new ResponseEntity<>(testCaseService.updateTestCase(id, testCaseDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTestCase(@PathVariable Long id){
        return new ResponseEntity<>(testCaseService.deleteTestCase(id), HttpStatus.OK);
    }

}