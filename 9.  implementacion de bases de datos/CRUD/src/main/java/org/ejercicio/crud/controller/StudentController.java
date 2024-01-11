package org.ejercicio.crud.controller;

import org.ejercicio.crud.DTO.StudentDTO;
import org.ejercicio.crud.service.IStudentService;
import org.ejercicio.crud.service.StudentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final IStudentService service;

    public StudentController(StudentServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createStudent(@RequestBody StudentDTO studentDTO) {
        return new ResponseEntity<>(service.saveStudent(studentDTO), HttpStatus.OK);
    }

    @GetMapping("/students")
    public ResponseEntity<?> getStudents() {
        return new ResponseEntity<>(service.getStudents(), HttpStatus.OK);
    }

    @PostMapping("edit/{id}")
    public ResponseEntity<?> editStudent(@PathVariable Long id,
                                         @RequestParam String newName,
                                         @RequestParam String newLastName) {
        return new ResponseEntity<>(service.editStudent(id, newName, newLastName), HttpStatus.OK);
    }

    @PostMapping("delate/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        return new ResponseEntity<>(service.deleteStudent(id), HttpStatus.OK);
    }
}
