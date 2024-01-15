package com.jpa.qaTesters.controller;

import com.jpa.qaTesters.entity.TestCase;
import com.jpa.qaTesters.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    @Autowired
    ITestCaseService testCaseService;
    @PostMapping("/new")
    public ResponseEntity<TestCase> addNewTestCase(@RequestBody TestCase testCase) {
        return ResponseEntity.ok(testCaseService.saveTestCase(testCase));
    }

    @PostMapping()
}
