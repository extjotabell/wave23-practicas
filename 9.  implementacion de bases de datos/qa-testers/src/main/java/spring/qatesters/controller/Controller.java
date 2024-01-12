package spring.qatesters.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.qatesters.dto.TestCaseDto;
import spring.qatesters.service.ITesterService;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/api/testcases")
public class Controller {

    @Autowired
    ITesterService service;

    @PostMapping("/new")
    public ResponseEntity<?> newTestCase(@RequestBody TestCaseDto testCaseDto){
        return new ResponseEntity<>(service.addTestCase(testCaseDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllTestCase(@RequestParam(required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Optional<LocalDate> lastUpdate) {
        if (lastUpdate.isPresent()) {
            return new ResponseEntity<>(service.getAllTestCasesAfterDate(lastUpdate), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
        }
    }

    @GetMapping("/api/testcases/id")
    public ResponseEntity<?> getTestCase( @PathVariable Long id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @PutMapping("/api/testcases/id")
    public ResponseEntity<?> updateTestCase(@PathVariable long id,
                                            @RequestParam(required = false) Optional <String> description,
                                            @RequestParam(required = false) Optional <Boolean> tested,
                                            @RequestParam(required = false) Optional <Boolean> passed){
        return new ResponseEntity<>(service.updateTestCase(id, description,tested,passed), HttpStatus.OK);
    }

    @DeleteMapping("/api/testcases/id")
    public ResponseEntity<?> deleteTestCase(){
        return new ResponseEntity<>(null);
    }

}
