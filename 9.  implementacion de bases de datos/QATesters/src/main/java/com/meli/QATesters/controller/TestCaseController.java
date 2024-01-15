package com.meli.QATesters.controller;

import com.meli.QATesters.dto.request.TestCaseRequestDTO;
import com.meli.QATesters.dto.response.ResponseDTO;
import com.meli.QATesters.dto.response.TestCaseResponseDTO;
import com.meli.QATesters.dto.response.TestsCaseResponseDTO;
import com.meli.QATesters.service.TestCaseService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    private final TestCaseService testCaseService;

    public TestCaseController(TestCaseService testCaseService){
        this.testCaseService = testCaseService;
    }

    @PostMapping("/new")
    public ResponseEntity<ResponseDTO> createTestCase(@RequestBody TestCaseRequestDTO testCaseRequestDTO){
        return new ResponseEntity<>(testCaseService.createTestCase(testCaseRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<TestsCaseResponseDTO> getTestsCase(@RequestParam(required = false) @DateTimeFormat(pattern = "dd/MM/yyyy")LocalDate last_update){
        if(last_update != null){
            return new ResponseEntity<>(testCaseService.getTestCaseListForDate(last_update), HttpStatus.OK);
        }
        return new ResponseEntity<>(testCaseService.getTestsCase(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseResponseDTO> getTestCaseById(@PathVariable Long id){
        return new ResponseEntity<>(testCaseService.getTestCase(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseResponseDTO> modifyTestCase(@PathVariable Long id,
                                            @RequestBody TestCaseRequestDTO testCaseRequestDTO){
        return new ResponseEntity<>(testCaseService.modifyTestCase(id, testCaseRequestDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deleteTestCase(@PathVariable Long id){
        return new ResponseEntity<>(testCaseService.deleteTestCase(id), HttpStatus.OK);
    }
}
