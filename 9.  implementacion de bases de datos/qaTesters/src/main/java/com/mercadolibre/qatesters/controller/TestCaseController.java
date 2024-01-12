package com.mercadolibre.qatesters.controller;

import com.mercadolibre.qatesters.dto.TestCaseDTO;
import com.mercadolibre.qatesters.service.ITestCaseService;
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
    ITestCaseService testCaseService;

    @PostMapping("new")
    public ResponseEntity<?> createTestCase(@RequestBody TestCaseDTO testCaseDTO) {
        return new ResponseEntity<>(testCaseService.addTestCase(testCaseDTO), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> getAllTestCases(@RequestParam(required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate last_update) {
        if (last_update != null) {
            return new ResponseEntity<>(testCaseService.getAllTestCasesAfterUpdateDate(last_update), HttpStatus.OK);
        }
        return new ResponseEntity<>(testCaseService.getAllTestCases(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTestCase(@PathVariable Long id) {
        return new ResponseEntity<>(testCaseService.getTestCase(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTestCase(@PathVariable long id, @RequestBody TestCaseDTO testCaseToUpdate) {
        return new ResponseEntity<>(testCaseService.updateTestCase(id, testCaseToUpdate), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestCase(@PathVariable long id) {
        return new ResponseEntity<>(testCaseService.deleteTestCase(id), HttpStatus.OK);
    }
}
