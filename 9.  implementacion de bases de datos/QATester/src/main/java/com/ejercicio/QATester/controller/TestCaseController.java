package com.ejercicio.QATester.controller;

import com.ejercicio.QATester.dto.TestCaseDTO;
import com.ejercicio.QATester.service.TestCaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/testcases")
public class TestCaseController {
    @Autowired
    private TestCaseServiceImpl testCaseService;

    @PostMapping("/new")
    public ResponseEntity<?> createTestCase(@RequestBody TestCaseDTO testCaseDTO) {
        return new ResponseEntity<>(testCaseService.createTestCase(testCaseDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTestCase(@RequestBody TestCaseDTO testCaseDTO, @PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.updateTestCase(testCaseDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestCase(@PathVariable Long id) {
        testCaseService.deleteTestCase(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllTestCases(@RequestParam(required = false) String last_update) {
        if (last_update != null && !last_update.isEmpty()) {
            return new ResponseEntity<>(testCaseService.getTestCasesByDate(last_update), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(testCaseService.getAllTestCases(), HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTestCaseById(@PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.getTestCaseById(id), HttpStatus.OK);
    }
}
