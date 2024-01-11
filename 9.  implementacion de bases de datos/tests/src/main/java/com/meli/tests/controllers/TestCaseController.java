package com.meli.tests.controllers;


import com.meli.tests.dtos.request.TestCaseDTO;
import com.meli.tests.services.ITestCaseService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/testcases")
public class TestCaseController {

    private final ITestCaseService testCaseService;

    public TestCaseController(ITestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @GetMapping
    public ResponseEntity<List<TestCaseDTO>> getAllTestCases(){
        return new ResponseEntity<>(testCaseService.getAllTestCases(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TestCaseDTO> createTestCase(@RequestBody TestCaseDTO testCaseDTO){
        return new ResponseEntity<>(testCaseService.createTestCase(testCaseDTO), HttpStatus.CREATED);
    }

}