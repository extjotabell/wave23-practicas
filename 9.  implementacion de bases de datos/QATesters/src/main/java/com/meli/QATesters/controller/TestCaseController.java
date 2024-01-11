package com.meli.QATesters.controller;

import com.meli.QATesters.dto.MessageDTO;
import com.meli.QATesters.dto.TestCaseDTO;
import com.meli.QATesters.service.ITestCaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    ITestCaseService service;

    public TestCaseController(ITestCaseService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public ResponseEntity<TestCaseDTO> createTestCase(@RequestBody TestCaseDTO testCaseDTO) {
        TestCaseDTO response = service.save(testCaseDTO);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping("/")
    public ResponseEntity<List<TestCaseDTO>> getAllTestCases() {
        List<TestCaseDTO> response = service.findAll();
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("")
    public ResponseEntity<List<TestCaseDTO>> getTestCasesByLastUpdateAfter(@RequestParam String last_update) {
        List<TestCaseDTO> response = service.findByLastUpdateAfter(last_update);
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDTO> getTestCaseById(@PathVariable Long id) {
        TestCaseDTO response = service.findById(id);
        return ResponseEntity.status(200).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseDTO> updateTestCase(@PathVariable Long id, @RequestBody TestCaseDTO testCaseDTO) {
        TestCaseDTO response = service.update(id, testCaseDTO);
        return ResponseEntity.status(200).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTestCase(@PathVariable Long id) {
        service.delete(id);
        MessageDTO response = new MessageDTO("Test case deleted");
        return ResponseEntity.status(200).build();
    }
}
